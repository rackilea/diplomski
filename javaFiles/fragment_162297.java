private static DecimalFormat df = new DecimalFormat("0.00000");

public static void main(String[] args)
{
        double d = 2 / (double) 52;
        System.out.println(df.format(d));

}