//separate file
public interface MyInterface {

    static void printMe() {
        System.out.println("Thing");
    }
}

public static void main(String[] args) throws Exception {
    MyInterface.printMe();
}