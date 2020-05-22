ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream stream = new ObjectOutputStream(baos);
stream.writeObject(myObject);

ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
ObjectInputStream inputStream = new ObjectInputStream(bais);
Object o = inputStream.readObject();