import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {

        String str = "ABCorp(sap234) #$% rain-drop(docman8) 093 (jac3k(turtle))";

        ArrayList<String> arr1 = new ArrayList<String>();
        ArrayList<String> arr2 = new ArrayList<String>();

        String s = "\\b(\\p{Graph}+)\\(([^)]+)\\)";
        Pattern p = Pattern.compile("("+s+")|(\\("+s+"\\))");
        Matcher m = p.matcher(str);

        while (m.find()) {
            arr1.add(m.group(m.group(1) == null ? 5 : 2));
            arr2.add(m.group(m.group(1) == null ? 6 : 3));
        }

        String[] one = arr1.toArray(new String[0]);
        String[] two = arr2.toArray(new String[0]);
        System.out.println(Arrays.toString(one));
        System.out.println(Arrays.toString(two));
    }
}