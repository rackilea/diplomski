int value = 123456789;
byte[] bigEndian = ByteBuffer.allocate(Integer.BYTES)
        .order(ByteOrder.BIG_ENDIAN)
        .putInt(value)
        .array();
byte[] littleEndian = ByteBuffer.allocate(Integer.BYTES)
        .order(ByteOrder.LITTLE_ENDIAN)
        .putInt(value)
        .array();
System.out.printf("value = 0x%08x = %d%n", value, value);
System.out.println(Arrays.toString(bigEndian));
System.out.println(Arrays.toString(littleEndian));