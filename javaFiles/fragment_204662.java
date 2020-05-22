import java.text.DecimalFormat;

public class mian55 {

    public static void main(String[] args) {
        System.out.println(" Kilograms  Pounds   |   Pounds   Kilograms");

        int kgs = 1;
        int lbs = 20;
        for (; kgs < 200 && lbs < 516; kgs += 2, lbs += 5){
            DecimalFormat decimal = new DecimalFormat("#.0");   
            System.out.println(String.format(" %7d  %7s    | %7d  %7s",
                    kgs, decimal.format(kgs * 2.2), lbs, decimal.format(lbs / 2.2)));
        }
    }
}