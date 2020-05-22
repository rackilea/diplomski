private void saveArrayList(ArrayList<String> arrayList) {
    try {
        FileOutputStream fileOutputStream = openFileOutput("your.filename", Context.MODE_PRIVATE);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(arrayList);
        out.close();
        fileOutputStream.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}