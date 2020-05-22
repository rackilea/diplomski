ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
ObjectOutputStream objOut = new ObjectOutputStream(arrayOut);

//write object

byte[] data = arrayOut.toByteArray(); //must keep a reference to this data! Contains serialized object

ByteArrayInputStream arrayIn = new ByteArrayInputStream(data);
ObjectInputStream objIn = new ObjectInputStream(arrayIn);

//read object