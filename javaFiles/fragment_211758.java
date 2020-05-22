public class StackError {

static int i = 1;

public static void main(final String[] args) throws Exception {
    System.out.print("1");
    doAnything();
    System.out.println("2");
}

private static void doAnything() {
    try {
        i++;
//          System.out.println(i);
        doAnything();
    } catch (Error e) {
        System.out.print("y"+i+"-");

    }
}
}