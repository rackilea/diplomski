LinkedList list = new LinkedList();
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("xxx"));
oos.writeObject(list);  <-- writeObject will be called here
oos.close();

ObjectInputStream oos = new ObjectInputStream(new FileInputStream("xxx"));
oos.readObject(list);  <-- readObject will be called here