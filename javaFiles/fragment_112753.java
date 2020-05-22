import java.util.*;

public class TestClass {
    // These should (most likely) not be static
    // Read up on what 'static' means
    String name;
    String gender;
    String hairColor;

    TestClass(String name, String gender, String hairColor){
        this.name = name;
        this.gender = gender;
        this.hairColor = hairColor;
    }

    public static void main (String[]args) {
        LinkedList<TestClass> linky = new LinkedList<TestClass>();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter name ");
        String name = input.nextLine();

        System.out.println("Enter gender ");
        String gender = input.nextLine();

        System.out.println("Enter hair color ");
        String hairColor = input.nextLine();

        TestClass info = new TestClass(name, gender, hairColor);

        linky.add(info);
    }
}