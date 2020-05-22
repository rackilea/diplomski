import java.util.*;

public class JTest
{
    public static void main(String[] args)
    {
    String str = "1001,\"Fitzsimmons, Des Marteau, Beale and Nunn\",109,\"George\",\"COD\",\"Standard\",,109,8/14/1998 8:50:02";
    String copy = new String();

    boolean inQuotes = false;

    for(int i=0; i<str.length(); ++i)
        {
        if (str.charAt(i)=='"')
            inQuotes = !inQuotes;
        if (str.charAt(i)==',' && inQuotes)
            copy += '|';
        else
            copy += str.charAt(i);
        }

    System.out.println(str);
    System.out.println(copy);
    }
}