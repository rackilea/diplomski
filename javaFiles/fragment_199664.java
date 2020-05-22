public class InterfaceExample {

public static void main(String[] argv) {
    PrintApple applePrinter = new PrintApple();
    PrintPear pearPrinter = new PrintPear();

    printObject(applePrinter);
    printObject(pearPrinter);
}

public static void printObject(PrintInterface p) {
    p.printMe(System.out);
}

public static interface PrintInterface {
    public void printMe(PrintStream p);
}

public static class PrintApple implements PrintInterface {
    public void printMe(PrintStream p) {
        p.println("apple");
    }
}

public static class PrintPear implements PrintInterface {
    public void printMe(PrintStream p) {
        p.println("pear");
    }
}