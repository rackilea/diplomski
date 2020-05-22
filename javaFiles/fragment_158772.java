public static void deSerialize_object(Serializable_test obj, String filename) {
    File a = new File(filename);     
    ObjectInputStream in = null;
    try {
        ObjectInputStream in =
            new ObjectInputStream(new BufferedInputStream(new FileInputStream(a)));
        Serializable_test newObj = (Serializable_test) in.readObject();
        obj.update(newObject);
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        if (in != null) in.close();
    }
}