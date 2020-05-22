private void writeObject(ObjectOutputStream os){
    try {
        os.defaultWriteObject();
        os.writeObject(car.type);
        os.writeInt(car.speed);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


private void readObject(ObjectInputStream is){
    try {
        is.defaultReadObject();
        String type = (String) is.readObject();
        int speed = is.readInt();
        this.car = new Car(type, speed);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}