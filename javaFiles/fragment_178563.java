public abstract class Homework {

    private int pagesToRead;
    private String typeHomework;

    // Same code

    // Define the toString here
    @Override
    public String toString() {
        return typeHomework + " - " + pagesToRead;
    }
}

public class MyMath extends Homework {

    // You don't need to define any extra attributes

    public MyMath(int pages, String hw) {
        super(pages,hw);
    }

    public void createAssignment(int p) {
        setTypeHomework("Math");
        setPagesToRead(p);
    }
}


public static void main(String[] args) {
    // Calls the constructor of the MyMath class, which in turn
    // invokes the constructor of its superclass, the 'Homework' class
    MyMath one = new MyMath(6, "Math");
    one.createAssignment(6);

    // Invokes the toString of the MyMath class. Since it does not have one,
    // The toString method of its superclass (Homework) is called.
    System.out.println(one);
}