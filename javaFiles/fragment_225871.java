import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Test> list = Arrays.asList(new Test(), new Test(), new Test());

        String myStr = list.stream().map(Test::getMessage)
                .collect(Collectors.joining(",", "optional prefix", "optional suffix"));
        System.out.println(myStr); // output = optional prefixmessage,message,messageoptional suffix

    }
}

class Test {
    public String getMessage() {
        return "message";
    }
}