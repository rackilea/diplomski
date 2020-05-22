import java.awt.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        int[] hsb = RGBtoHSB(0, 0, 255);

        for (int value: hsb)
            System.out.println( value );
    }

    public static int[] RGBtoHSB(int red, int green, int blue)
    {
        float[] hsbFloat = Color.RGBtoHSB(red, green, blue, null);
        int[] hsbInt = new int[3];

        hsbInt[0] = Math.round( hsbFloat[0] * 360 );
        hsbInt[1] = Math.round( hsbFloat[1] * 100 );
        hsbInt[2] = Math.round( hsbFloat[2] * 100 );

        return hsbInt;
    }
}