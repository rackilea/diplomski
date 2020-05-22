public DoAES() {

    try {
        myCipher = Cipher.getInstance(Cipher.ALG_AES_BLOCK_128_ECB_NOPAD, false);
        myAESKey = (AESKey) KeyBuilder.buildKey(KeyBuilder.TYPE_AES,
                KeyBuilder.LENGTH_AES_128, false);
    } catch (CryptoException e) {
        ISOException.throwIt(((CryptoException) e).getReason());
    }
}

public static void install(byte bArray[], short bOffset, byte bLength)
        throws ISOException {
        (new DoAES()).register();
}