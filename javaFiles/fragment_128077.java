// Compiles under 1.7 but not 1.8
public class Test {
    public static void main (String args[]) {
        Object x = Boolean.valueOf(true);
        Object y = new Boolean(true);
        System.out.println(x == true); // Prints true
        System.out.println(y == true); // Prints false
    }
}