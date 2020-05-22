import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

public class HelloWorld{

     public static void main(String []args){
        String s = "1+3+5";
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "270.5");
        map.put("3", "377.5");
        map.put("5", "377.5");
        StringBuffer result = new StringBuffer();
        Matcher m = Pattern.compile("\\d+").matcher(s);
        while (m.find()) {
            String value = map.get(m.group());
            if (value != null) {
                m.appendReplacement(result, value);
            } else {
                m.appendReplacement(result, m.group());
            }
        }
        m.appendTail(result);
        System.out.println(result.toString());
     }
}