import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.pechen.Person;

public class Demo {
    public static void main(String [] args) throws Exception{
        String filename = "person.obj";            
        Person person = new Person();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(person);
        out.close();

        Person p;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        p = (Person)in.readObject();
        in.close();
        System.out.println("Read Person: " + p.toString());
     }
}