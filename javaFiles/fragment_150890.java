import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String args[]){

        Test test = new Test();
        String sentence1 = "whats the number of apple";
        String expression1 = "whats the (number of @1|@1s number)";
        HashMap<Integer, String> map1 = test.extract(sentence1, expression1);
        System.out.println(map1);
        String sentence2 = "whats the bananas number";
        HashMap<Integer, String> map2 = test.extract(sentence2, expression1);
        System.out.println(map2);
        String sentence3 = "hello Jhon how are you";
        String expression3 = "(hello|hi) @1 how are @2";
        HashMap<Integer, String> map3 = test.extract(sentence3, expression3);
        System.out.println(map3);
    }

    public HashMap<Integer,String> extract(String sentence, String expression){
        expression = expression.replaceAll("\\(", "\\(?:");
        ArrayList<Integer> keys = new ArrayList<Integer>();
        String regex4Expression = "@([\\d]*)";
        Pattern pattern4Expression = Pattern.compile(regex4Expression);
        Matcher matcher4Expression = pattern4Expression.matcher(expression);
        while(matcher4Expression.find()){
            for(int i = 1; i <= matcher4Expression.groupCount(); i++){
                if(!keys.contains(Integer.valueOf(matcher4Expression.group(i)))){
                    keys.add(Integer.valueOf(matcher4Expression.group(i)));
                }
            }
        }
        String regex = expression.replaceAll("@[\\d]*", "([\\\\w]*)");
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        while(matcher.find()){
            ArrayList<String> targets = new ArrayList<String>();
            for(int i = 1; i <= matcher.groupCount(); i++){
                if(matcher.group(i) != null){
                    targets.add(matcher.group(i));
                }
            }
            for(int j = 0; j < keys.size(); j++){
                map.put(j + 1, targets.get(j));
            }
        }
        return map;
    } 
}