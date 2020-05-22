@SuppressWarnings("unchecked")
public static <T> T readObject(
    ObjectInputStream in
) throws IOException, ClassNotFoundException {
    return (T)in.readObject();
}