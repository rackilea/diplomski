import java.util.regex.Matcher;
import java.util.regex.Pattern;

String str = "BaseDS66";

Pattern p = Pattern.compile("(\\d+)", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
Matcher m = p.matcher(str);

if (m.find()) {
    String originalValueString = m.group(1);
    int originalValue = Integer.parseInt(originalValueString);
    originalValue++;
    String newStr = str.replace(originalValueString, String.valueOf(originalValue));
    log.info("Incremented value: " + newStr);
    vars.put("Str", newStr);
}