public class Trimimg
{
    public static void main(String[]args)
    {
        String str = "AASS MON 01 2013 365.00 HJJ Call";

        String newStr = str.replace(" HJJ", "");

        System.out.println(newStr);
    }
}