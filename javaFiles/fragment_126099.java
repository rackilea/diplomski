public static byte[] fromBGR555(Color[] p) {
        ByteBuffer b = ByteBuffer.allocate(p.length * 2).order(
                ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < p.length; i++) {
            int num = 0;
            num += (p[i].getRed() / 0x08);
            num += ((p[i].getGreen() / 0x08) << 5);
            num += ((p[i].getBlue() / 0x08) << 10);
            b.putShort((short) num);
        }
        return b.array();
    }