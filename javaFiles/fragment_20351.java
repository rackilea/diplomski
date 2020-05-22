package nl.stackoverflow.www.so;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    private String rules = "{[1;3] || [7;9;10-13] || [34;32]}";

    public static void main( String[] args )
    {
        new App();
    }

    public App() {

        String[] values = {"11 12", "10 11 12 13", "1 2 3", "1 3", "32 23", "23 32 53 34"}; 

        // Iterate over each value in String array
        for (String value : values) {
            if (isWithinRules(value)) {
                System.out.println("Success: " + value);
            }
        }   
    }

    private boolean isWithinRules(String inputValue) {
        boolean result = false;

        // || is a special char, so you need to escape it with \. and since \ is also a special char
        // You need to escape the \ with another \ so \\| is valid for one | (pipe)
        String[] orRules = rules.split("\\|\\|");

        // Iterate over each or rules
        for (String orRule : orRules) {

            // Remove [] and {} from rules
            orRule = orRule.replace("[", "");
            orRule = orRule.replace("]", "");
            orRule = orRule.replace("{", "");
            orRule = orRule.replace("}", "");
            orRule.trim();

            // Split all and rules of or rule
            String[] andRules = orRule.split(";");

            boolean andRulesApply = true;

            // Iterate over all and rules
            for (String andRule : andRules) {
                andRule = andRule.trim();

                // check if andRule is range
                if (andRule.contains("-")) {
                    String[] andRulesRange = andRule.split("-");
                    int beginRangeAndRule = Integer.parseInt(andRulesRange[0]);
                    int endRangeAndRule = Integer.parseInt(andRulesRange[1]);

                    List<String> andRangeRules = new ArrayList<String>();
                    // Add all values to another rule array
                    while (beginRangeAndRule < endRangeAndRule) {
                        andRangeRules.add(Integer.toString(beginRangeAndRule));
                        beginRangeAndRule++;
                    }

                    for (String andRangeRule : andRangeRules) {
                        // Check if andRule does not contain in String inputValue
                        if (!valueContainsRule(inputValue, andRangeRule)) {
                            andRulesApply = false;
                            break;
                        }
                    }

                } else {
                    // Check if andRule does not contain in String inputValue
                    if (!valueContainsRule(inputValue, andRule)) {
                        andRulesApply = false;
                        break;
                    }
                }
            }

            // If andRules apply, break and set bool to true because string contains all andRules
            if (andRulesApply) {
                result = true;
                break;
            }
        }

        return result;
    }

    private boolean valueContainsRule(String val, String rule) {
        boolean result = true;

        // Check if andRule does not contain in String inputValue
        if (!val.contains(rule)) {
            result = false;
        }

        return result;
    }
}