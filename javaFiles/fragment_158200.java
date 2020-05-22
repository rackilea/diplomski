import java.io.*;

public class Bar {

    private interface Foo extends Runnable, Serializable {}

    public static void main (String[] args) 
            throws InterruptedException, IOException, ClassNotFoundException {

        Runnable foo = new Foo() {
            @Override
            public void run() {
                System.out.println("Lala");
            }
        };

        Thread t = new Thread(foo);
        t.start();
        t.join();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(foo);
        oos.close();
        Foo foofoo = (Foo) new ObjectInputStream(
            new ByteArrayInputStream(baos.toByteArray())).readObject();

        t = new Thread(foofoo);
        t.start();
        t.join();
    }
}