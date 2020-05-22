FileOutputStream fos = new FileOutputStream("myFoos.tmp");
ObjectOutputStream oos = new ObjectOutputStream(fos);

List<Foo> foos = new ArrayList<Foo>();
//Fill the list.

oos.writeObject(foos);

//...

FileInputStream fis = new FileInputStream("myFoos.tmp");
ObjectInputStream ois = new ObjectInputStream(fis);

ArrayList<Foo> mySavedFoo = (ArrayList<Foo>) ois.readObject();