import java.util.regex.*;

public class Foo {
    public static void main(String[] args) {
        String regex = ".*inventory<\\/b>: ([-.\\d]+).*Equipped<\\/b>: ([-.\\d]+).*";
        String text = "<td> <b>In inventory</b>: 0.3 &#107;&#103;<br /><b>Equipped</b>: -4.5&#160;kg";

        // Look for a match
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Get the matched text
        if (matcher.matches()) {
            String inventoryWeight = matcher.group(1);
            String equippedWeight = matcher.group(2);

            System.out.println("Inventory weight: " + inventoryWeight);
            System.out.println("Equipped weight: " + equippedWeight);
        } else {
            System.out.println("No match!");
        }
    }
}