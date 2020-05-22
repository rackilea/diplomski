byte[] buffer = new byte[]{-84,-19,0,5};
ByteArrayOutputStream out = new ByteArrayOutputStream();
ObjectOutputStream objectOutputStream= new ObjectOutputStream(out);
objectOutputStream.write(buffer);
objectOutputStream.flush();

ObjectInput input = new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
System.out.println("input.available(): " + input.available());
System.out.println("input.readByte(): " + input.readByte());