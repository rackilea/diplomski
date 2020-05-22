import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "\\s+([A-Z])\\s+";
final String string = "FROM lineitem A INNER JOIN orders B ON (B.O_ORDERKEY = A.L_ORDERKEY) INNER JOIN customer C ON (C.C_CUSTKEY = B.O_ORDERKEY)";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println("Full match: " + matcher.group(0));
    for (int i = 1; i <= matcher.groupCount(); i++) {
        System.out.println("Group " + i + ": " + matcher.group(i));
    }
}