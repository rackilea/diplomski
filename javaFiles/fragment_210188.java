import java.io.Serializable;

public abstract class Base implements Serializable {

    private int x = 0;
    private int y = 0;

    private static final long serialVersionUID = 1L;

    public String toString()
    {
        return "Base X: " + x + ", Base Y: " + y;
    }
}



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sub extends Base {

    private int z = 0;

    private static final long serialVersionUID = 1000L;

    public String toString()
    {
        return super.toString() + ", Sub Z: " + z;
    }

    public static void main(String[] args)
    {
        Sub s1 = new Sub();
        System.out.println( s1.toString() );

        // Serialize the object and save it to a file
        try {
            FileOutputStream fout = new FileOutputStream("object.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject( s1 );
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sub s2 = null;
        // Load the file and deserialize the object
        try {
            FileInputStream fin = new FileInputStream("object.dat");
            ObjectInputStream ois = new ObjectInputStream(fin);
            s2 = (Sub) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println( s2.toString() );
    }
}