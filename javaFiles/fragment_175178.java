import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str = "https://oc.tc/forums/topics/523b038faf7fb046f700255dhttps://oc.tc/tjandralala";
        String[] split = str.split("https");
        System.out.println(Arrays.toString(split));
    }
}