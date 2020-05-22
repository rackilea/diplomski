public class Dummy {
    public static void main(String[] args) {
        double min = 0.0;
        double max = 3.0;
        double d = 0.5;

        for (double n = min; n <= max; n+=d) {
            double result =  (Math.pow(n*(n/1), 2)) / 4; // {N(N/1)^2}/4
            System.out.print(result + ", ");
        }
    }
}