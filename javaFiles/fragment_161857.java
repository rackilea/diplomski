import java.util.*;

class MyValuePair {
    private int intValue;
    private double doubleValue;

    MyValuePair(double doubleValue, int intValue) {
        this.intValue = intValue;
        this.doubleValue = doubleValue;
    }

    //Getter and Setter as well as constructor(s) as needed
    public String toString() {
        return "(" + doubleValue + ", " + intValue + ")";
    }

}

public class Dijkstra {

    static Map<Integer, MyValuePair> map = new HashMap<>();

    public static void main(String[] args) {
        MyValuePair pair = new MyValuePair(4.0, 5);
        map.put(1, pair);
        System.out.println(map);
    }

}