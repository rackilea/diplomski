protected void serializeCM() {
    try {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("serialized.txt"));
        os.writeObject(currentMap);
        os.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}