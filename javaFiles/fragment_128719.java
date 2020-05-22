public void readTrainsFromFile(ArrayList<Train> array, String file) {
    FileInputStream fileInputStream = new FileInputStream(file);

    try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
        int trainCount = objectInputStream.readInt();
         for (int i = 0; i < trainCount; i++) {
            array.add((Train)objectInputStream.readObject());
        }
    }
}