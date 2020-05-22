import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    String log = "Log.d(\"Hello there \" + x + \", I see your are \" + y + \" years old!\");";
    System.out.println("Input: " + log);
    Pattern p = Pattern.compile("(?:(\\w+)\\s*\\+\\s*)?\"((?:[^\"\\\\]|\\\\.)*+)\"(?:\\s*\\+\\s*(\\w+))?");
    Matcher m = p.matcher(log);
    StringBuilder output = new StringBuilder(25);
    List<String> arguments = new ArrayList<String>(5);
    output.append("Log.d(\"");
    while (m.find()) {
        if (m.group(1) != null) {
            output.append("%s");
            arguments.add(m.group(1));
        }
        output.append(m.group(2));
        if (m.group(3) != null) {
            output.append("%s");
            arguments.add(m.group(3));
        }
    }
    output.append("\"");
    for (String arg : arguments) {
        output.append(", ").append(arg);
    }
    output.append(");");
    System.out.println("Output: " + output);
  }
}