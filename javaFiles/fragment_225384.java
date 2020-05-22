public class usefunc {

    static {
        System.loadLibrary("usefunc");
    }
    public native int function(double a[], double b);

    public static void main(String args[]) {
        double a[] = new double[1];
        new usefunc().function(a,1.0);
        System.out.println("a[0] = " + a[0]);
    }
}