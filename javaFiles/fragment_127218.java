import  java.util.regex.Pattern;
      import  java.util.regex.Matcher;
 /**
    <P>{@code java RegexForRepeatingString}</P>
  **/
 public class RegexForRepeatingString  {
    public static final void main(String[] ignored)  {

       String sRegex = "\\b[a-z]+:[+-]?[a-z_0-9]+\\b";

       String sToSearch = "keya:valuea|keyb:valueb|keyc:valuec|keyd:valued";

       Matcher m = Pattern.compile(sRegex).matcher(sToSearch);

       while(m.find())  {
          System.out.println(m.group());
       }
    }
 }