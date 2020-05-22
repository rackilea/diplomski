public class Test{

    public static void main (String args[]) throws IOException, ClassNotFoundException{
        A a = new A();

        B b = new B();
        b.a = a;

        C c = new C();
        c.a = a;

        System.out.println("b.a == c.a is " + (b.a == c.a));

        // Case 1 - when two diferent files are used to write the objects
        FileOutputStream fout = new FileOutputStream("c:\\b.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(b);
        oos.close();
        fout.close();

        fout = new FileOutputStream("c:\\c.ser");
        oos = new ObjectOutputStream(fout);
        oos.writeObject(c);
        oos.close();
        fout.close();

        FileInputStream fileIn = new FileInputStream("c:\\b.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        B bCopy = (B) in.readObject();
        in.close();
        fileIn.close();

        fileIn = new FileInputStream("c:\\c.ser");
        in = new ObjectInputStream(fileIn);
        C cCopy = (C) in.readObject();
        in.close();
        fileIn.close();
        System.out.println("Case 1 - bCopy.a == cCopy.a is " + (bCopy.a == cCopy.a));

        // Case 2 - when both the objects are saved in the same file
        fout = new FileOutputStream("c:\\both.ser");
        oos = new ObjectOutputStream(fout);
        oos.writeObject(b);
        oos.writeObject(c);
        oos.close();
        fout.close();


        fileIn = new FileInputStream("c:\\both.ser");
        in = new ObjectInputStream(fileIn);
        bCopy = (B) in.readObject();
        cCopy = (C) in.readObject();
        in.close();
        fileIn.close();
        System.out.println("Case 2 - bCopy.a == cCopy.a is " + (bCopy.a == cCopy.a));
    }
}

class A implements Serializable{

}

class B implements Serializable{
    A a;
}

class C implements Serializable{
    A a;
}