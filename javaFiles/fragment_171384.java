import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
/**
   <P>{@code java ArtTypesXmpl}</P>
 **/
public class ArtTypesXmpl  {
   public static final void main(String[] igno_red)  {
     String sToSearch = "This is a test\nAnother test\n#art\n#paintings#collections";

     Matcher mHashThenWord = Pattern.compile("#(\\w+)").matcher(sToSearch);

     while(mHashThenWord.find())  {
        System.out.println(mHashThenWord.group(1));
     }
   }
}