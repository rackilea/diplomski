import java.io.*;

public class Human implements Serializable {
    private int age;
    private String name;

    public void setAge(int a) {
        this.age = a;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String toString() {
        return "[Human " + this.age + ", " + this.name + "]";
    }

    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("data.txt"))))
        {
            Human human = new Human();
            human.setAge(21);
            human.setName("Test");
            System.out.println("Human : " + human);
            oos.writeObject(human);
            human = new Human(); // <== Change
            human.setAge(21);    // <== Change
            human.setName("Test123");
            oos.writeObject(human);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("data.txt"))))
        {
            Human newHuman  = (Human)ois.readObject();
            System.out.println("newHuman1 :" + newHuman);
            newHuman  = (Human)ois.readObject();
            System.out.println("newHuman2 :" + newHuman);
        }
    }
}