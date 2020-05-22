public class SHA256withRSACustomPadding extends PSSSignatureSpi {
    public SHA256withRSACustomPadding(int padding) {
        super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), padding, 1));
    }

    public void initSign(PrivateKey privateKey) throws InvalidKeyException {
        engineInitSign(privateKey);
    }

    public void update(byte[] data) throws SignatureException {
        engineUpdate(data,0,data.length);
    }

    public byte[] sign() throws SignatureException {
        return engineSign();
    }

    public void initVerify(PublicKey publicKey) throws InvalidKeyException {
        engineInitVerify(publicKey);
    }

    public boolean verify(byte[] data) throws SignatureException {
        return engineVerify(data);
    }
}