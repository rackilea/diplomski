import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestStack1305864 {

    @Test
    public void matcherWithCdataAndComments(){
        String s="The quick <span>brown</span> <a href=\"www.fox.org\">fox</a> jumped over the lazy <![CDATA[ > ]]> <a href=\"entry://id=6000009\">dog</a> <img src=\"dog.png\" />.";
        String r="The quick brown fox jumped over the lazy <a href=\"entry://id=6000009\">dog</a> .";
        String pattern="((<a href=\"entry://id=\\d+\">.*?</a>)|<!\\[CDATA\\[.*?\\]\\]>|<!--.*?-->|<.*?>)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);

        String t = s.replaceAll(pattern, "$2");
        System.out.println(t);
        System.out.println(r);
        assertEquals(r, t);
    }
}