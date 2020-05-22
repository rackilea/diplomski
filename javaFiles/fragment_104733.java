File file = new File("car.obj"); //must keep a reference to this file! Specified where serialized object is
ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));

//write object

ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

//read object