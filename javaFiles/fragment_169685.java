import java.util.ArrayList;
import java.util.List;

public class Test20170118 {

    public static void main(String[] args) {
    String s = "esempio";
    List<String> result = new ArrayList<>();
    result.add("");
    System.out.println(method(s, result));
    System.out.println(method(s, result).size());
    }

    private static List<String> method(String input, List<String> done){
    List<String> result = new ArrayList<>();
    if(input.length() == 1){
        for (String string : done) {
        result.add(string);
        result.add(string + input);
        }
        return result;
    } else {
        for (String string : done) {
        result.add(string);
        result.add(string + input.substring(0, 1));
        }
        return method(input.substring(1), result);
    }
    }

}