import java.util.*;
public class t {
    public static void main(String... args)  { 
        String line = "01.05,2000.5000";
        StringTokenizer strTok = new StringTokenizer(line, ",.");
        List<Integer> values = new ArrayList<Integer>();
        while (strTok.hasMoreTokens()) {
            String s = strTok.nextToken();
            if (s.length() == 0) { 
                // Found a repeated separator, String is not valid, do something about it
            } 
            try { 
                int value = Integer.parseInt(s, 10);
                values.add(value);
            } catch(NumberFormatException e) { 
                // Number not valid, do something about it or continue the parsing 
            }
        }

        // At the end, get an array from the ArrayList
        Integer[] arrayOfValues = values.toArray(new Integer[values.size()]);

        for (Integer i : arrayOfValues) {
            System.out.println(i);
        }
    }
}