import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MyClass {
    public static void main(String args[]) {
        String str = "asdjnk -#+-+1m245.g34.34";
        System.out.println("Input : " + str);
        double result = Double.parseDouble(extractNumber(str));
        System.out.println("Final result: " + result);    
    }

    public static String extractNumber(String input){

        //replace all characters except digits, +-.
        String regex = "[^-+0-9.]";
        input = input.replaceAll(regex, "");
        System.out.println("After remove non-digit characters: " + input);
        /* 
          number format: 
          [-]? : if there is 0 or 1 minus sign
          [0-9]+ : one or more digits
          [.]{1}[0-9]+ : . followed by one or more digits
        */
        regex = "[-]?[0-9]+([.]{1}[0-9]+)?";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(input);
        if(matcher.find())
            return (matcher.group(0));
        else 
            return "error, no numbers exists!";

    }

}