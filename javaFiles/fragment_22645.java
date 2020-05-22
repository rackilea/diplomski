import java.io.*;

public class Test implements Serializable {

    public static final void main(String[] args) {
        try
        {
            // Create a Thing
            Thing t = new Thing();
            t.put("foo", "bar");

            // Write it out
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("foo"));
            os.writeObject(t);
            os.close();
            os = null;

            // Read it in
            Thing t2;
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("foo"));
            t2 = (Thing)is.readObject();
            is.close();
            is = null;

            // Same underlying map for both properties?
            System.out.println("t2.mapsAreSameObject? " + t2.mapsAreSameObject());
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}