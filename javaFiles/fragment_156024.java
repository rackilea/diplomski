public class FlushAndReset {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        Foo foo = new Foo();
        for (int i = 0; i < 10; i++) {
            foo.setValue(i);
            oos.writeObject(foo);
            oos.flush();
            // oos.reset();
        }

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        for (int i = 0; i < 10; i++) {
            Object obj = ois.readObject();
            System.out.println(obj);
        }
    }
}