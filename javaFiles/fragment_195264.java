import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class RegExDemo2 {

        public static void main(String [] args)
        {
            String input = "A B (C D) E";
            String output = input.replaceAll("\\s\\([^)]*?\\)", "").trim();
            ArrayList<String> newoutput = new ArrayList(Arrays.asList(output.split(" ")));
            Pattern p = Pattern.compile("\\((.*?)\\)");
            Matcher m = p.matcher(input);

            while(m.find()) {
                newoutput.add(m.group(1));
            }
            for(String test: newoutput)
            {
                System.out.println("Array "+test);
            }
        }

    }