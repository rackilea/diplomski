import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        String text = "500.00";
        double number = Double.parseDouble(text);

        DecimalFormat format = new DecimalFormat("0.00");
        String formatted = format.format(number);
        System.out.println(formatted);
    }
}