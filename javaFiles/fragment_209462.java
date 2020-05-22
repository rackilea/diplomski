package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1
{
    public static void main(String[] args)
    {
        String[] strings = new String[]
        { "localhost/gar/garmin-first/gar_home", "localhost/garmin-first/gar_home" };
        Pattern pat = Pattern.compile("(?<=/)(.*?)(?=/)");
        for(String s : strings)
        {
            System.out.println("For: " + s);
            Matcher matcher = pat.matcher(s);
            while (matcher.find())
            {
                System.out.println(matcher.group());
            }
        }
    }
}