ByteBuffer buffer = ByteBuffer.allocate(0x1000);
    buffer.order(ByteOrder.BIG_ENDIAN);

    buffer.putInt(100);
    //store booleans as 1 or 0 in a byte
    buffer.put((byte) (true ? 1 : 0));
    buffer.put((byte) (false ? 1 : 0));

    //store string as [int length, byte array]
    String str = "Hello World!";
    byte[] strBytes = str.getBytes(StandardCharsets.UTF_8); //use any charset you want here
    buffer.putInt(strBytes.length);
    buffer.put(strBytes);


    buffer.flip();
    byte[] data = new byte[buffer.remaining()];
    buffer.get(data);
    System.out.println("Total Bytes: " + data.length);


    ByteBuffer bb = ByteBuffer.wrap(data);

    System.out.println(bb.getInt());
    System.out.println(bb.get() != 0);
    System.out.println(bb.get() != 0);
    byte[] inStr = new byte[bb.getInt()];
    bb.get(inStr);
    String myStr = new String(inStr, StandardCharsets.UTF_8);
    System.out.println(myStr);