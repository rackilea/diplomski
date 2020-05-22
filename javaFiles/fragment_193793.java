byte keyType = 101;
    byte keyLength = 3;
    byte[] key = {27, // or whatever your key is
                  55, 
                  111};
    long timestamp = System.currentTimeMillis();

    // If your data is just a string, then you could do the following.
    // However, you will likely want to provide the getBytes() method
    // with an argument that specifies which text encoding you are using.
    // The default is just the current platform's default charset.
    byte[] data = "your string data".getBytes();
    short dataSize = (short) data.length;

    int totalSize = (1 + 1 + keyLength + 8 + 2 + dataSize);
    ByteBuffer bytes = ByteBuffer.allocate(totalSize);

    bytes.put(keyType);
    bytes.put(keyLength);
    bytes.put(key);
    bytes.putLong(timestamp);
    bytes.putShort(dataSize);
    bytes.put(data);

    // If you want everthing as a single byte array:
    byte[] byteArray = bytes.array();