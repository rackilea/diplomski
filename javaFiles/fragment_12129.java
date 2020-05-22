import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoginProgram {
    public static void main(String[] args) {
        String seinRuutS = "10 20";
        List<String> list = Arrays.asList(seinRuutS.split(" "));
        List<Integer> seinRuutX = list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        System.out.println(seinRuutX.get(0) + seinRuutX.get(1));
        // Log.d("qwer", (seinRuutX.get(0) + seinRuutX.get(1)));
    }
}