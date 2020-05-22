public class FractionOfDay {

    public static double fractionOfDay(double h, double m, int s, char a ) {
        double y = -1;
        if (a == 'P' && h == 12) {
            double x = (h * 60 * 60) + (m * 60) + (s);
             y = x / 86400;
        } else if (a == 'P' && h != 12) {
            double x = ( (h + 12) * 60 * 60) + (m * 60) + (s);
            y = x / 86400;
        } else if (a == 'A' && h == 12) {
            double x = (m * 60) + (s);
            y = x / 86400;
        } else if (a == 'A' && h != 12) {
            double x = ( (h) * 60 * 60) + (m * 60) + (s);
            y = x / 86400;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(fractionOfDay(12, 0, 0, 'P'));
    }
}