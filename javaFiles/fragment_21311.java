public class Sample {
    static Sample s = new Sample();
    static final int x = 5;
    static int y = 10;

    public Sample() {
        int z = x + y;
        System.out.println(z);
    }

    public static void main(String[] args) {

    }

}