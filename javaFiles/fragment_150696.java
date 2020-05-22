package stackoverflow.counting;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("TRA");
        list3.add("XXX");

        int length = 3;
        String user_input = "TR.*";

        if (length == 3) {
            System.out.println("Possible solutions:");
            int n = 0;
            for (int i = 0; i < list3.size(); i++) {
                String s = list3.get(i);
                if (s.matches(user_input)) {
                    System.out.println(s);
                    n++;
                }
            }
            System.out.println(n);
            if (n == 0) {
                System.out.println("No solutions found");
            }
        }
    }
}