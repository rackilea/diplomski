//Test1 is a class name identifier 
public class Test1 {
    // add is identifier for a method
    public static int add(int a, int b) {
    return a + b;
}

public static void main(String[] args) {
    int c; // c is identifier for a variable
    int a = 5;
    c = add(a, 10);
    if (c > 10)
        print("c = " + -c); // c is a String
    else
        print(c); // c is a int
    print("Hello World"); // Hello World is a String
}

/**
 * Method Overriding
 */
private static void print(int c) {
    System.out.println("In Integer Print Method "+c);
}

private static void print(String string) {
    System.out.println("In String Print Method "+string);
}

}