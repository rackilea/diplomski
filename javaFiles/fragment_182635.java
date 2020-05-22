ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream os = new ObjectOutputStream(bos);
    os.writeInt(1000);
    os.writeInt(2000);
    os.writeInt(3000);
    os.close();

    // Client receive the bytes
    final byte[] bytes = bos.toByteArray();

    ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(bytes));
    System.out.println(is.readInt());
    System.out.println(is.readInt());
    System.out.println(is.readInt());