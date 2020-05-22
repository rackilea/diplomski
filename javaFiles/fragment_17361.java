import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDateFromURL {

     public static void main(String []args) {
        String URL = "https://s3-ap-southeast-1.amazonaws.com/mtpdm/2019-06-14/12-14/1001_1203_20190614120605_5dd404.jpg";

        Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{1,2})");
        Matcher matcher = pattern.matcher(URL);

        if (matcher.find()) {
            System.out.println(matcher.group(1)); // Do what you need to do with the result
        }
     }
}