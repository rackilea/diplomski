public class Main {
    public static void main(String args[]) {
        int n = 6;
        while (n > 0) {
            for (int i = 1; i <= n; i++) {
                System.out.print(i);
            }
            for (int i = n; i > 0; i--) {
                System.out.print(i);
            }
            System.out.println("");
            n--;
        }
    }
}