import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String text_string= "59701=Application+Development\"\">app dev</a>| <a href=\"\"/search/search.asp?cdlCustomFieldValue001=Data+Analytics+(formerly+Business+Intelligence)\"\">Data Analytics (formerly Business Intelligence)</a>| <a href=\"\"/search/search.asp?cdlCustomFieldValueID012=Small+and+Midmarket+Cloud+Solutions\"\">Small and Midmarket Cloud Solutions</a></td></tr><tr class=\"\"CstmFldRow noVpad CfProfessional\"\" style=\"\"\"\"><td valign=\"\"top\"\"><label class=\"\"CstmFldLbl\"\">";
        Pattern pattern_sub51 = Pattern.compile("\"\">(.*?)</a>");
        Matcher matchersub51 = pattern_sub51.matcher(text_string);
        List<String> res = new ArrayList<>();
        while(matchersub51.find())
        {
            res.add(matchersub51.group(1).trim());
        }
        System.out.println(res);
    }
}