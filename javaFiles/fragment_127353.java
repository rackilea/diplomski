import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Define your regex
Pattern regex = Pattern.compile("<[^>]*>");
// Get your matches
Matcher m = regex.matcher("{your-input-here}");
// Iterate through your matches
while(m.find()){
    // Output each match
    System.out.println(m.group(0));
}