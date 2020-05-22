import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "\\[(School_Teacher_Name)]";
final String string = "[School_Teacher_Name] is our new member, So please congratulate [School_Teacher_Name] .";
final String subst = "Yash Mathur";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

// The substituted value will be contained in the result variable
final String result = matcher.replaceAll(subst);

System.out.println("Substitution result: " + result);