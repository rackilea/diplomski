import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main
{
public static void main(String[] args) {
    String input = "item1  , item2  , item3 , item4 ";
    String regex = "^\\s*([a-z]\\w+)\\s*,\\s*([a-z]\\w+)\\s*,\\s*([a-z]\\w+)\\s*,\\s*([a-z]\\w+)\\s*$";
    Pattern pat = Pattern.compile(regex);
    Matcher m = pat.matcher(input);
    m.find();
    for (int i = 1; i <= m.groupCount(); i++) {
        System.out.println(m.group(i));
    }
    System.out.println("----------");
    regex = "^\\s*([a-z]\\w+)(?:\\s*,\\s*([a-z]\\w+))*\\s*$";
    pat = Pattern.compile(regex);
    m = pat.matcher(input);
    m.find();
    for (int i = 1; i <= m.groupCount(); i++) {
        System.out.println(m.group(i));
    }
}
}


Output:

item1
item2
item3
item4
----------
item1
item4