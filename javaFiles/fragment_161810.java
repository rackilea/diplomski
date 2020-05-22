public class PrintBackwards {

    public static void main(String[] args) {
        char[] a = new char[] {'A', 'B', 'C', 'D'};

        for(int i = a.length - 1; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }
}