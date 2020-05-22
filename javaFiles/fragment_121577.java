public class Test {
public static void main(String args[]) {
    String regex = "\\((\\w\\,?)*\\)";
    Pattern pattern = Pattern.compile(regex);
    String str = "((1,2,3,4),(a,b,c,d))";

    Matcher matcher = pattern.matcher(str);
    while(matcher.find()) {
        // you can extract strings here.
        System.out.println(matcher.group());
    }   
  }
}