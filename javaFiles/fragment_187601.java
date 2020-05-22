import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        final String string = "    This is  a   very    short    text    .     ";
        final String replace = " ";
        final String subst = "♥";

        String result = myReplaceFunction(string, replace, subst, 4);

        System.out.println(result);
    }

    public static String myReplaceFunction(String text, String replaceThis, String withThis, int countOfConsecutive) {
        replaceThis = Pattern.quote(replaceThis);

        final String regex = String.format("(?<!%1$s)%1$s{%2$s}(?!%1$s)", replaceThis, countOfConsecutive);

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(text);

        final String result = matcher.replaceAll(withThis);

        return "Substitution result: " + result;
    }
}