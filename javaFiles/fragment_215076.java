public class MySerializable implements Serializable{
    String value;
    transient String test = "default";

    public MySerializable() {
        test = "init";
    }

    private void readObject(java.io.ObjectInputStream in)
         throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        test = "init";
    }
}