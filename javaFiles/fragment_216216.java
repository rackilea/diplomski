ArrayList<NoteCard> cardArray = new ArrayList<>();

try {
    FileInputStream fis = openFileInput(rootFile);
    ObjectInputStream ois = new ObjectInputStream(fis);
    Object object = ois.readObject();
    if (object instanceof ArrayList) {
        ArrayList arrayList = (ArrayList) object;
        for (Object object : arrayList) {
            cardArray.add((NoteCard) object);
        }
    }
    ois.close();
    fis.close();
} catch(FileNotFoundException e) {
    e.printStackTrace();
} catch(IOException e) {
    e.printStackTrace();
} catch(ClassNotFoundException e) {
    e.printStackTrace();
}