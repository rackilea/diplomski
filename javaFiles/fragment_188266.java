import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test
{
    public static void main(String[] args) {
        String tests[] = {
            "add switch(123,456)->(45,67),(8,100)",
            "  add switch (19 , 310) -> (21 , 890) , (1 ,  2)  "
        };
        for (String test: tests) {
            Pattern pattern = Pattern.compile("^\\s*add\\s+switch\\s*(?:\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\))\\s*->\\s*(?:\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\))\\s*,\\s*(?:\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\))\\s*$");
            Matcher m = pattern.matcher(test);
            if (m.find()) {
                for (int i = 0; i <= 6; ++i) {
                    System.out.println("Group " + i + " = " + m.group(i));
                }
                System.out.println();
            }
        }
    }
}