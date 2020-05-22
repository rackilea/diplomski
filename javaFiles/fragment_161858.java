public class Dijkstra {

    static Map<Integer, Dijkstra> map = new HashMap<>();

    private double doubleValue;
    private int intValue;

    public Dijkstra(int intValue, double doubleValue) {
        this.intValue = intValue;
        this.doubleValue = doubleValue;
    }

    public String toString() {
        return "(" + doubleValue + ", " + intValue + ")";
    }

    public static void main(String[] args) {
        Dijkstra pair = new Dijkstra(4.0, 5);
        map.put(1, pair);
        System.out.println(map);
    }

}