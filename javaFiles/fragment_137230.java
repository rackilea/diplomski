public class Temp {
    public static void main(String args[] ) throws Exception {
        int[] x = new int[1];
        System.out.println(x[0]); // 0, the default value for int[] entries
        changeIt(x);
        System.out.println(x[0]); // 42, it changed
    }

    private static void changeIt(int[] a) {
        a[0] = 42;
    }
}