import java.util.*;
import java.util.regex.*;

public class Main { 

    public static List<String> tokens(String line) {
        if(!line.matches("('(''|[^'])*'|\\d+)(\\s*,\\s*('(''|[^'])*'|\\d+))*")) {
            return null;
        }
        Matcher m = Pattern.compile("'(''|[^'])*+'|\\d++").matcher(line);
        List<String> tok = new ArrayList<String>();
        while(m.find()) tok.add(m.group());
        return tok;
    }

    public static void main(String[] args) {
        String[] tests = {
                "1, 2, 3",
                "'a', 'b',    'c'",
                "'a','b','c'",
                "1, 'a', 'b'",
                "'this''is''one string', 1, 2",
                "'''this'' is a weird one', 1, 2",
                "'''''''', 1, 2",
                /* and some invalid ones */
                "''', 1, 2",
                "1 2, 3, 4, 'aaa'",
                "'a', 'b', 'c"
        };
        for(String t : tests) {
            System.out.println(t+" --tokens()--> "+tokens(t));
        }
    }
}