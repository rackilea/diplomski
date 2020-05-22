import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Hello implements Serializable {
  public String h1;
  public String h2;

  @Override
  public String toString() {
    return "{ h1: " + h1 + ", h2: " + h2 + " }";
  }

  public static void main(String[] args) throws Exception {
    Hello h = new Hello();

    h.h1 = "hello";
    h.h2 = "world";

    ObjectOutputStream outstream = new ObjectOutputStream(new FileOutputStream("hello.ser"));
    outstream.writeObject(h);

    System.out.println("1) h: " + h);

    h = null;

    System.out.println("2) h: " + h);

    ObjectInputStream instream = new ObjectInputStream(new FileInputStream("hello.ser"));
    h = (Hello) instream.readObject();

    System.out.println("3) h: " + h);

  }
}