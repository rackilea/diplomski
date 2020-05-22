import java.util.List;
import java.util.ArrayList;



public class HelloWorld
{
  public static void main(String[] args)
  {
    String s = "{col1=RND393JKDN, col2=DJW//39ndo==8}";
        s=s.substring(1, s.length()-1); //remove {}
        s.replaceAll(" ", "");
        String[] explode = s.split(",");
        List<String> result = new ArrayList<String>();
        for (int i=0; i<explode.length; i++) {
            String keyAndValue = explode[i];
            int at = keyAndValue.indexOf("=");
            String value = keyAndValue.substring(at+1);
            result.add(value);
        }
        String finalResult = "";
        for (String val : result) {
            finalResult+=val+", ";
        }
        finalResult=finalResult.substring(0, finalResult.length()-2);
        System.out.println(finalResult);
  }
}