PipedOutputStream pipedOutputStream = new PipedOutputStream();
PipedInputStream pipedInputStream = new PipedInputStream();

pipedInputStream.connect(pipedOutputStream);

ObjectOutputStream objectOutputStream = new ObjectOutputStream(pipedOutputStream);
ObjectInputStream objectInputStream = new ObjectInputStream(pipedInputStream);

objectOutputStream.writeObject("Hello world!");
String message = (String)objectInputStream.readObject();

System.out.println(message);