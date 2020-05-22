import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HelloWorld{

 public static void main(String []args){
    String test = "1304150 1304151 1304152 1304153 1304154 1304155 1304156 1304157 1304158 1304159\r\n" +
                  "5304150 5304151 5304152 5304153 5304154 5304155 5304156 5304157 5304158 5304159\r\n" + 
                  "7304150 7304153 71304156";

    Pattern p = Pattern.compile("(\\d{6})0 (?:\\1)1 (?:\\1)2 (?:\\1)3 (?:\\1)4 (?:\\1)5 (?:\\1)6 (?:\\1)7 (?:\\1)8 (?:\\1)9", Pattern.MULTILINE);
    Matcher m = p.matcher(test);

    while (m.find()) {
        System.out.println(new String(m.group(1)) + "X");
    }
 }