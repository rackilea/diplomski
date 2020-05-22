public class PrintBackwards {

    private static char[] a = new char[]{'A', 'B', 'C', 'D'};

    public static void main(String[] args) {
        printBackwards(0);
    }

    public static void printBackwards(int i) {
        if (i < a.length) {
            printBackwards(++i);
            System.out.println(a[i - 1]);
        }
    }
}