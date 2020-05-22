import java.text.*;

public class DecimalPlaces {

    public static void main(String[] args) {

        double d = 1.234567;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print(df.format(d));
    }

}