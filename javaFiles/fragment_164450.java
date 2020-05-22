class Packet {

    byte field1;
    byte field2;
    short field3;
    byte field4;
    int field5;
    int field6;

    public Packet(byte[] data) {
        ByteBuffer buf = ByteBuffer.wrap(data)
                                   .order(ByteOrder.LITTLE_ENDIAN);

        field1 = buf.get();
        field2 = buf.get();
        field3 = buf.getShort();
        field4 = buf.get();
        field5 = buf.getInt();
        field6 = buf.getInt();
    }
}