byte[] bytes = new byte[4];

DataInputStream dataStream = new DataInputStream(stream);
while (dataStream.available() > 0) {
    int intValue = dataStream.readUnsignedShort();

    int charValue;
    int b = dataStream.read();
    if (b < 0x80) {
        charValue = b;
    }
    else {
        int byteCount;
        if (b >= 0xf0) {
            byteCount = 4;
        } else if (b >= 0xe0) {
            byteCount = 3;
        } else {
            byteCount = 2;
        }

        bytes[0] = (byte) b;
        dataStream.readFully(bytes, 1, byteCount - 1);
        String s = new String(bytes, 0, byteCount, 
            StandardCharsets.UTF_8);
        charValue = s.codePointAt(0);
    }

    // Do something with intValue and charValue
}