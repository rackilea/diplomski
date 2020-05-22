public class Test1 implements Serializable {

    public static void main(String[] args) throws Exception {
        ObjectOutputStream os1 = new ObjectOutputStream(new FileOutputStream("test"));
        os1.writeObject(new Test1());
        os1.close();

        ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("test", true)) {
            protected void writeStreamHeader() throws IOException {
                reset();
            }
        };

        os2.writeObject(new Test1());
        os2.close();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("test"));
        System.out.println(is.readObject());
        System.out.println(is.readObject());