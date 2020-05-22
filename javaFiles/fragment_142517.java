import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ideone
{

    private static List<Integer> indices = new ArrayList<Integer>();
    private static List<String> result = new ArrayList<String>();

    public static void main (String[] args) throws java.lang.Exception
    {

        String str = "a:b?:c??:d???:e????:f";

        Pattern pattern = Pattern.compile("(?<!\\?)(?:\\?{2})*:");
        Matcher matcher = pattern.matcher(str);

        while(matcher.find()) {
            result.add(str.substring(getLastIndex(), matcher.end() - 1));
            indices.add(matcher.end());
        }
        result.add(str.substring(getLastIndex()));
        System.out.print(result);
    }

    private static int getLastIndex() {
        if(indices.isEmpty()) {
            return 0;
        } else {
            return indices.get(indices.size() - 1);
        }
    }
}