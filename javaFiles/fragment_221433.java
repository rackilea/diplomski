import java.util.*;
import java.lang.*;
import java.util.regex.*;

class Main
{
    public static void main (String[] args)
    {
        String s="குமார்";
        List<String> characters=new ArrayList<String>();
        Pattern pat = Pattern.compile("\\p{L}\\p{M}*");
        Matcher matcher = pat.matcher(s);
        while (matcher.find()) {
            characters.add(matcher.group());            
        }

        // Test if we have the right characters and length
        System.out.println(characters);
        System.out.println("String length: " + characters.size());

    }
}