import java.util.ArrayList;

/**
 *
 * @author Chirag
 */

public class Test {

    public static void main(String[] args) {

        ArrayList<Order> d = new ArrayList<>();
        Order s = new Order("Stack", "Overflow");
        //creating an object 
        Order s2 = new Order("Stack", "Overflow");
        //creating another object with same value
        d.add(s);
        //adding to list
        System.out.println("s == s2: " + ((s == s2) ? "Yes" : "No"));
        System.out.println("s.equals(s2): " + (s.equals(s2) ? "Yes" : "No"));

        System.out.println("values of object s: name:" + s.getName() + ", val:" + s.getVal() + ";");
        System.out.println("values of object s2: name:" + s2.getName() + ", val:" + s2.getVal() + ";");

        System.out.println("list contains s2 an object with same values as object s: " + (d.contains(s2) ? "Yes" : "No"));
    }

    static class Order {

        private final String name, val;

        public String getName() {
            return name;
        }

        public String getVal() {
            return val;
        }

        public Order(String name, String val) {
            this.name = name;
            this.val = val;
        }
    }
}