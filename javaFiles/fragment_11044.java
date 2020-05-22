public class Test {

    static int k = 1;
    static {k = 2;}

    public static void main(String[] args) {
        System.out.println(k);
    }

}