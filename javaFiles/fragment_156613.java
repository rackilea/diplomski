import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDog {
    public static void main(String args[])
    {
        Collar c=new Collar(2);
        Dog d=new Dog(c, 5);
        System.out.println("before collar size is :"+d.getCollar().getCollarSize());

        try{
            FileOutputStream fs=new FileOutputStream("serializeDog.ser");
            ObjectOutputStream os=new ObjectOutputStream(fs);
            os.writeObject(d);
            os.close();
        }catch(Exception e){e.printStackTrace();}


        try{
            FileInputStream fis=new FileInputStream("serializeDog.ser");
            ObjectInputStream ois=new ObjectInputStream(fis);
            d=(Dog)ois.readObject();
            ois.close();

        }catch(Exception e){e.printStackTrace();}

        System.out.println("after collar size is: "+d.getCollar().getCollarSize());
    }
}





class Dog implements Serializable{
    private Collar theCollar;
    private int dogSize;
    public Dog(Collar collar,int size)
        {
        theCollar=collar;
        dogSize=size;
        }
    public Collar getCollar()
        {
        return theCollar;
        }
}