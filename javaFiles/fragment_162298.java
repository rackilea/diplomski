private static DecimalFormat df = new DecimalFormat();

public static void main(String[] args)
{
            df.setMaximumFractionDigits(5);
            double d = 2 / (double) 52;
            System.out.println(df.format(d));
}