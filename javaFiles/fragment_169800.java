import java.util.*;

public class TestingSets {
    public static void main(String[] args) {
        Set<Set<String>> mainSet = new HashSet<Set<String>>();
        Set<String> s;
        for (int i=0; i<10; i++){
            s = new HashSet<String>();
            s.add("Hi "+i);
            mainSet.add(s);
        }
    }
}