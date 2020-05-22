public class Tester {
    public static void main (String[] args) {
        double d = 1;
        NumberFormat numFormat = NumberFormat.getInstance();
        numFormat.setMaximumFractionDigits(3);
        numFormat.setMinimumFractionDigits(2);
        System.out.println(numFormat.format(d));
    }
}