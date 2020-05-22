public static void install(byte[] bArray, short bOffset, byte bLength) {
    byte aidLength = bArray[bOffset];
    short controlLength = (short)(bArray[(short)(bOffset+1+aidLength)]&(short)0x00FF);
    short dataLength = (short)(bArray[(short)(bOffset+1+aidLength+1+controlLength)]&(short)0x00FF);
    new MyPinCard(bArray, (short) (bOffset+1+aidLength+1+controlLength+1), dataLength).register(bArray, (short) (bOffset + 1), aidLength);
}

private MyPinCard(byte[] bArray, short bOffset, short bLength) {
    if(bLength!=(short)(2)) {
        ISOException.throwIt(ISO7816.SW_WRONG_DATA);
    }
    // ....
    m_pin = new OwnerPIN(PIN_TRY_LIMIT, (byte)2);
    m_pin.update(bArray, bOffset, (byte)2);
    // ....
}