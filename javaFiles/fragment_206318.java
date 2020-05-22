public static String toString(Serializable o) throws IOException {
    //                   what is this? ^
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(output);
    oos.writeObject(o); //Here you are saving a Serializable object to... what? Which file?
    oos.close();
    return new String(Base64.encode(output.toByteArray(), Base64.DEFAULT));
}