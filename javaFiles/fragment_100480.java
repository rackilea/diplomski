import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;

class Test {  
    public static void main(String args[]) {
    String[] data = { "[1] test", " [2] [3] text ", " just some text " };

    for (String s : data) {
        String r0 = null;
        Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(s);
        if (matcher.find()) {
            r0 = matcher.group(1);
        }
        System.out.print(r0 + " ");
    }
    System.out.println();

    for (String s : data) {
        String r1 = null;
        r1 = s.replaceAll(".*\\[|\\].*", "");
        System.out.print(r1 + " ");
    }
    System.out.println();

    for (String s : data) {
        String r2 = null;
        int i = s.indexOf("[");
        int j = s.indexOf("]");
        if (i != -1 && j != -1) {
            r2 = s.substring(i + 1, j);
        }
        System.out.print(r2 + " ");
    }
    System.out.println();
    }
}