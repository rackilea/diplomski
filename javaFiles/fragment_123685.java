ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(baos);
String myStrObj = "Hello World";
oos.writeObject(myStrObj); //write the string as object
oos.close();


ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
String readStrObj = (String) ois.readObject(); //read the string as object
ois.close();
System.out.println(readStrObj);