public void writeTrainsToFile(ArrayList<Train> array, String file) {
    FileOutputStream fileOutputStream = new FileOutputStream(file);

    try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
        objectOutputStream.writeInt(array.size());
        for(Train train: array) {
            objectOutputStream.writeObject(train);
        }
    }
}