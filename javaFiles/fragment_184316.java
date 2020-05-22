import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.*;

class Ideone {
    public static void main(String[] args) throws java.lang.Exception {
        // Check for rude words before sending to server
        String result = "heres bilbobaggins haha";
        String patternString = "(bilbo|baggins|in|the|shire)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher findRudeWords = pattern.matcher(result.toLowerCase());

        while (findRudeWords.find()) {
            // Replace the bad word with asterisks
            result = result.replaceAll("(?i)" + findRudeWords.group(1), "*");
        }
        System.out.println("result=" + result);
    }

}