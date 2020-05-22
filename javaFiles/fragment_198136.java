import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ff {
    static Pattern numberPart=Pattern.compile("([0-9.]*)\\b*m");
    static DecimalFormat df=new DecimalFormat("0.0#####");

    public static String format(String input)
    {
        Matcher m=numberPart.matcher(input);
        if(m.matches())
        {
            return df.format(Double.parseDouble(m.group(1)));
        }
        return null;
    }
    public static void main(String args[]) {
        System.out.println(format("6.000m"));
        System.out.println(format("4.900m"));
        System.out.println(format("4.750m"));
    }
}