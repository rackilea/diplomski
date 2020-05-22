private ArrayList<String> getSavedArrayList() {
    ArrayList<String> savedArrayList = null;

    try {
        FileInputStream inputStream = openFileInput("your.filename");
        ObjectInputStream in = new ObjectInputStream(inputStream);
        savedArrayList = (ArrayList<String>) in.readObject();
        in.close();
        inputStream.close();

    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    return savedArrayList;
}