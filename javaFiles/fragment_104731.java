File file = new File("car.obj");
FileOutputStream fileOut = new FileOutputStream(file);
ObjectOutputStream objOut = new ObjectOutputStream(fileOut);

objOut.writeObject(new Car()); //write
objOut.close();

FileInputStream fileIn = new FileInputStream(file);
ObjectInputStream objIn = new ObjectInputStream(fileIn);

Car car = (Car) objIn.readObject();