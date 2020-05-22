import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import hex.Hex;

public class PoorMansKDF {

    public interface KeyDerivationParameters extends AlgorithmParameterSpec {
        String getDerivedKeyAlgorithm();
        int getDerivedKeySize();
        byte[] getCanonicalInfo();
    }

    public static class KeyDerivationParametersWithLabel implements KeyDerivationParameters {

        private final String algorithm;
        private final int keySize; 
        private final String label;

        public KeyDerivationParametersWithLabel(String algorithm, int keySize, String label) {
            this.algorithm = algorithm;
            this.keySize = keySize;
            this.label = label;
        }

        @Override
        public byte[] getCanonicalInfo() {
            if (label == null) {
                // array without elements
                return new byte[0];
            }
            return label.getBytes(StandardCharsets.UTF_8);
        }

        @Override
        public String getDerivedKeyAlgorithm() {
            return algorithm;
        }

        @Override
        public int getDerivedKeySize() {
            return keySize;
        }
    }

    private enum State {
        CONFIGURED,
        INITIALIZED;
    }

    public static PoorMansKDF getInstance() throws NoSuchAlgorithmException {
        return new PoorMansKDF();
    }

    private final Mac hmac;
    private State state;

    private PoorMansKDF() throws NoSuchAlgorithmException {
        this.hmac = Mac.getInstance("HMACSHA256");
        this.state = State.CONFIGURED;
    }

    public void init(Key key) throws InvalidKeyException {
        if (key.getAlgorithm().equalsIgnoreCase("HMAC")) {
            key = new SecretKeySpec(key.getEncoded(), "HMAC"); 
        }

        hmac.init(key);
        this.state = State.INITIALIZED;
    }

    public Key deriveKey(KeyDerivationParameters info) {
        if (state != State.INITIALIZED) {
            throw new IllegalStateException("Not initialized");
        }

        final int keySize = info.getDerivedKeySize();
        if (keySize < 0 || keySize % Byte.SIZE != 0 || keySize > hmac.getMacLength() * Byte.SIZE) {
            throw new IllegalArgumentException("Required key incompatible with this KDF");
        }
        final int keySizeBytes = keySize / Byte.SIZE;

        // we'll directly encode the info to bytes
        byte[] infoData = info.getCanonicalInfo();
        final byte[] fullHMAC = hmac.doFinal(infoData);
        final byte[] derivedKeyData;
        if (fullHMAC.length == keySizeBytes) {
            derivedKeyData = fullHMAC;
        } else {
            derivedKeyData = Arrays.copyOf(fullHMAC, keySizeBytes);
        }

        SecretKey derivedKey = new SecretKeySpec(derivedKeyData, info.getDerivedKeyAlgorithm());
        Arrays.fill(derivedKeyData, (byte) 0x00);
        if (fullHMAC != derivedKeyData) {
            Arrays.fill(fullHMAC, (byte) 0x00);
        }
        return derivedKey;
    }

    // test only
    public static void main(String[] args) throws Exception {
        var kdf = PoorMansKDF.getInstance();
        // input key (zero byte key for testing purposes, use your own 16-32 byte key)
        // do not use a password here!
        var masterKey = new SecretKeySpec(new byte[32], "HMAC");
        kdf.init(masterKey);

        // here "enc" is a label, in this case for a derived key for ENCryption 
        var labeledParameters = new KeyDerivationParametersWithLabel("AES", 256, "enc");
        var derivedKey = kdf.deriveKey(labeledParameters);
        // use your own hex decoder, e.g. from Apache Commons
        System.out.println(Hex.encode(derivedKey.getEncoded()));

        var aesCipher = Cipher.getInstance("AES/GCM/NoPadding");
        var gcmParams = new GCMParameterSpec(128, new byte[12]);
        aesCipher.init(Cipher.ENCRYPT_MODE, derivedKey, gcmParams);
        var ct = aesCipher.doFinal();
        System.out.println(Hex.encode(ct));
    }
}