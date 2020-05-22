import java.text.DecimalFormat;
import java.math.RoundingMode;
public class Test
{
   public static void main(String args[])
   {
        double i = 69.8999999999;
        DecimalFormat format = new DecimalFormat("#.#"); 
        format.setRoundingMode(RoundingMode.FLOOR);
        String s = format.format(i);
        i = Double.parseDouble(s);
        System.out.println(i); //should be 69.8
   }
}