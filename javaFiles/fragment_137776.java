public class Leibnitz
{
    public static void main(String argv[])
    {
        double answer = Math.PI / 4; //answer
        double numTheory = 1; //answer
        double j = -3; //counts the Denominator
        int i = 0; //counts loop

        System.out.print("How many iterations does it take to compute pi this series: ");
        while (Math.abs(answer + numTheory) > 1e-6)
        {
            j += 2;
            numTheory += 1 / (++i % 2 == 0 ? -j : j);
        }
        System.out.println(i);
    }
}