public static void saveKeyToFile(SecretKey key)
        throws FileNotFoundException, IOException {
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
            "/path/to/mysavedobject"));
    oos.writeObject(key);
    oos.close();
}

public static SecretKey getKeyFromFile(String dir) throws IOException,
        ClassNotFoundException {
    if (dir == null) { 
        dir = "/path/to/mysavedobject";
    }
    SecretKey key = null;
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
            dir));
    key = (SecretKey) ois.readObject();
    ois.close();
    return key;
}