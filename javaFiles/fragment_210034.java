/**
 * Adapter for bouncy castle crypto implementation (decryption).
 *
 * @author olaf@merkert.de
 * @author owlstead
 */
public class AESDecrypterOwlstead extends AESCryptoBase implements AESDecrypter {


    private final boolean verify;

    public AESDecrypterOwlstead(boolean verify) {
        this.verify = verify;
    }

    // TODO consider keySize (but: we probably need to adapt the key size for the zip file as well)
    public void init( String pwStr, int keySize, byte[] salt, byte[] pwVerification ) throws ZipException {
        byte[] pwBytes = pwStr.getBytes();

        super.saltBytes = salt;

        PBEParametersGenerator generator = new PKCS5S2ParametersGenerator();
        generator.init( pwBytes, salt, ITERATION_COUNT );

        cipherParameters = generator.generateDerivedParameters(KEY_SIZE_BIT*2 + 16);
        byte[] keyBytes = ((KeyParameter)cipherParameters).getKey();

        this.cryptoKeyBytes = new byte[ KEY_SIZE_BYTE ];
        System.arraycopy( keyBytes, 0, cryptoKeyBytes, 0, KEY_SIZE_BYTE );

        this.authenticationCodeBytes = new byte[ KEY_SIZE_BYTE ];
        System.arraycopy( keyBytes, KEY_SIZE_BYTE, authenticationCodeBytes, 0, KEY_SIZE_BYTE );

        // based on SALT + PASSWORD (password is probably correct)
        this.pwVerificationBytes = new byte[ 2 ];
        System.arraycopy( keyBytes, KEY_SIZE_BYTE*2, this.pwVerificationBytes, 0, 2 );

        if( !ByteArrayHelper.isEqual( this.pwVerificationBytes, pwVerification ) ) {
            throw new ZipException("wrong password - " + ByteArrayHelper.toString(this.pwVerificationBytes) + "/ " + ByteArrayHelper.toString(pwVerification));
        }

        cipherParameters = new KeyParameter(cryptoKeyBytes);

        // checksum added to the end of the encrypted data, update on each encryption call

        if (this.verify) {
            this.mac = new HMac( new SHA1Digest() );
            this.mac.init( new KeyParameter(authenticationCodeBytes) );
        }

        this.aesCipher = new SICZIPBlockCipher(new AESFastEngine());
        this.blockSize = aesCipher.getBlockSize();

        // incremented on each 16 byte block and used as encryption NONCE (ivBytes)

        // warning: non-CTR; little endian IV and starting with 1 instead of 0

        nonce = 1;

        byte[] ivBytes = ByteArrayHelper.toByteArray( nonce, 16 );

        ParametersWithIV ivParams = new ParametersWithIV(cipherParameters, ivBytes);
        aesCipher.init( false, ivParams );
    }

    // --------------------------------------------------------------------------

    protected CipherParameters cipherParameters;

    protected SICZIPBlockCipher aesCipher;

    protected HMac mac;


    @Override
    public void decrypt(byte[] in, int length) {
        if (verify) {
            mac.update(in, 0, length);
        }
        aesCipher.processBytes(in, 0, length, in, 0);
    }

    public byte[] getFinalAuthentication() {
        if (!verify) {
            return null;
        }
        byte[] macBytes = new byte[ mac.getMacSize() ];
        mac.doFinal( macBytes, 0 );
        byte[] macBytes10 = new byte[10];
        System.arraycopy( macBytes, 0, macBytes10, 0, 10 );
        return macBytes10;
    }
}