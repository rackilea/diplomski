import java.util.regex.Matcher;
import java.util.regex.Pattern;

String pattern = "\\w+";
Pattern r = Pattern.compile(pattern);
String tempString =
  "<element1>content1</element1><element2>content2</element2>";
String[] tempArray = tempString.split ("(<\\w+>)|(</\\w+>)");
for (String item:tempArray)
  {
      Matcher matcher = r.matcher(item);
      //check if the pattern matches 
      if(matcher.matches()){
          System.out.println ("Item: " + item);
      }
  }