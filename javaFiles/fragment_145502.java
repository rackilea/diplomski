import java.util.regex.Pattern;
import java.util.regex.Matcher;

private static final Pattern VALID_VIN_NUMBER = Pattern.compile(
    "[0-9a-zA-Z]{1,9}");

public static boolean isVin(String s) {
  return VALID_VIN_NUMBER.matcher(s).matches();
}