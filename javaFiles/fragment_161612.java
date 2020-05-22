import java.util.*;

class Example {
    static void accept(Double d) {}

    public static void main(String[] args) {
        accept(false ? 1.0 : new HashMap<String, Double>().get("1"));
    }
}