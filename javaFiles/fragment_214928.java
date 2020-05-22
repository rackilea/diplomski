import java.util.regex.Matcher;
import java.util.regex.Pattern;

...

public static String analyse(String text) {
   text = text.toLowerCase();
   int posCount = 0;
   int negCount = 0;
   String positive = "good|awesome";
   String negative = "bad|terrible";

   Pattern positivePattern = Pattern.compile(positive);
   Pattern negativePattern = Pattern.compile(negative);

   Matcher matcher = positivePattern.matcher(text);
   while(matcher.find()) {
       posCount++;
   }
   matcher = negativePattern.matcher(text);
   while(matcher.find()) {
       negCount++;
   }

   String res = Integer.toString(posCount);
   String res1 = Integer.toString(negCount);
   String result = (posCount+"P"+negCount+"N");

   return result;                       
}