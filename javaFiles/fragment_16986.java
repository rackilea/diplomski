public class Test
{
    public static void main(String[] args) {
        double a = Double.NaN;
        double b = Double.NaN;
        double c = 5;

        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(b < c);
        System.out.println(c < b);
    }
}