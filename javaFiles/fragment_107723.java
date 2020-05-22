ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);


    oos.writeObject(obj);

    oos.flush();
    oos.close();

    InputStream is = new ByteArrayInputStream(baos.toByteArray());