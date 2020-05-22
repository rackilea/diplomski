public class MiniApplet extends Applet {
     public static void install(byte[] bArray, short bOffset, byte bLength) {
        // GP-compliant JavaCard applet registration
        new MiniApplet().register(bArray, (short) (bOffset + 1),
                bArray[bOffset]);
     }

    private final AESKey aesKey = (AESKey)KeyBuilder.buildKey(KeyBuilder.TYPE_AES_TRANSIENT_DESELECT, KeyBuilder.LENGTH_AES_128, false);
    private final Cipher aes = Cipher.getInstance(Cipher.ALG_AES_BLOCK_128_CBC_NOPAD, false);

    public void process(APDU apdu) {
    // Good practice: Return 9000 on SELECT
    if (selectingApplet()) {
        return;
    }

    final byte[] buf = apdu.getBuffer();
    final short dataLen = apdu.setIncomingAndReceive(); 
    final byte ins = buf[ISO7816.OFFSET_INS];

    switch (ins) {
    case (byte) 0x00: //KEY VALUE INIT FROM APDU
        if (dataLen != 16) //checking key value length
            ISOException.throwIt(ISO7816.SW_WRONG_LENGTH)
        aesKey.setKey(buf, ISO7816.OFFSET_CDATA);
        break;
    case (byte) 0x01: //DECRYPTION
    case (byte) 0x02: //ENCRYPTION
        if ((dataLen & 0x000F) != 0) //checking if input data is block-aligned
            ISOException.throwIt(ISO7816.SW_WRONG_LENGTH)

        if (!aesKey.isInitialized())
            ISOException.throwIt(ISO7816.SW_CONDITIONS_NOT_SATISFIED);
        aes.init(aesKey, (ins == 0x02) ? Cipher.MODE_ENCRYPT : Cipher.MODE_DECRYPT);
        aes.doFinal(buf, ISO7816.OFFSET_CDATA, dataLen, buf, ISO7816.OFFSET_CDATA);
        apdu.setOutgoingAndSend(ISO7816.OFFSET_CDATA, dataLen);
        break;
    default:
        // good practice: If you don't know the INStruction, say so:
        ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
    }
}

}