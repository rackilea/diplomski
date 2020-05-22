public class concat {
    public static void main (String[] args) {
        int t = 0;
        int k = 5;
        int x = 3;

        k <<= 3;
        k |= x;
        // or, in one line: k = (k << 3) | x;

        System.out.println(k);
    }
}