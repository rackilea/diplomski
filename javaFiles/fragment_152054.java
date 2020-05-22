ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);

    // i want to write **byteArray** here. What method should I use?
    dos.writeShort(byteArray.length);
    dos.write(byteArray);

    dos.writeUTF("Name");
    dos.writeInt(ctr);
    dos.flush();
    outputRecord = baos.toByteArray();