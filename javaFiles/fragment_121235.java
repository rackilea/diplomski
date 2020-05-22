import java.util.*;

public class Temp {

    public static void main(String[] args) {
        String input = "4 5 \\rad";
        input = input.replaceAll("\\\\[a-zA-Z0-9]*", "");
        System.out.println(input);
    }
}