ByteArrayOutputStream buffer = new ByteArrayOutputStream();

ObjectOutputStream oos = new ObjectOutputStream(buffer);

oos.writeObject(obj);

oos.close();

byte[] rawData = buffer.toByteArray();