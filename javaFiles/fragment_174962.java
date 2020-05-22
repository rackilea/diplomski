private static final int AES_BLOCK_SIZE = 16;
private InputStream mUpstream;
private Cipher mCipher;
private SecretKeySpec mSecretKeySpec;
private IvParameterSpec mIvParameterSpec;

public StreamingCipherInputStream(InputStream inputStream, Cipher cipher, 
    SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec) {
    super(inputStream, cipher);
    mUpstream = inputStream;
    mCipher = cipher;
    mSecretKeySpec = secretKeySpec;
    mIvParameterSpec = ivParameterSpec; }
@Override
public int read(byte[] b, int off, int len) throws IOException {
    return super.read(b, off, len);  }
public long forceSkip(long bytesToSkip) throws IOException {
    long skipped = mUpstream.skip(bytesToSkip);
    try {
        int skip = (int) (bytesToSkip % AES_BLOCK_SIZE);
        long blockOffset = bytesToSkip - skip;
        long numberOfBlocks = blockOffset / AES_BLOCK_SIZE;

        BigInteger ivForOffsetAsBigInteger = new BigInteger(1, 
        mIvParameterSpec.getIV()).add(BigInteger.valueOf(numberOfBlocks));
        byte[] ivForOffsetByteArray = ivForOffsetAsBigInteger.toByteArray();
        IvParameterSpec computedIvParameterSpecForOffset;
        if (ivForOffsetByteArray.length < AES_BLOCK_SIZE) {
            byte[] resizedIvForOffsetByteArray = new byte[AES_BLOCK_SIZE];
            System.arraycopy(ivForOffsetByteArray, 0, resizedIvForOffsetByteArray, 
            AES_BLOCK_SIZE - ivForOffsetByteArray.length, ivForOffsetByteArray.length);
            computedIvParameterSpecForOffset = new IvParameterSpec(resizedIvForOffsetByteArray);
        } else {
            computedIvParameterSpecForOffset = new IvParameterSpec(ivForOffsetByteArray, ivForOffsetByteArray.length - AES_BLOCK_SIZE, AES_BLOCK_SIZE);
        }
        mCipher.init(Cipher.ENCRYPT_MODE, mSecretKeySpec, computedIvParameterSpecForOffset);
        byte[] skipBuffer = new byte[skip];
        mCipher.update(skipBuffer, 0, skip, skipBuffer);
        Arrays.fill(skipBuffer, (byte) 0);
    } catch (Exception e) {
        return 0;
    }
    return skipped;
}
@Override
public int available() throws IOException {
    return mUpstream.available();}