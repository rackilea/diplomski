byte[] data = new byte[]{(byte) 0xDB, (byte) 0xA7, 0x53, (byte) 0xF8, (byte) 0xA8, 0x0C, 0x66, 0x8};
    long a = 989231983928329832L;
    byte[] bytes = ByteBuffer.allocate(8).putLong(a).array();
    for(int i = 0; i<8; i++){
        System.out.printf("%02x\t%02x\n", data[i], bytes[i]);
    }
    System.out.println(Long.parseLong(hexStringFromHexData(bytes), 16));