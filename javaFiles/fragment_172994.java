import java.util.*;

public class Test extends ArrayList<String> {
    public static void main(String[] args) {
        List raw = new Test();
        raw.add(3);
    }
    public boolean add(String o) {
        return super.add(o);
    }
}