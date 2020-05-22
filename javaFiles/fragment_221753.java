import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMap {
    static class Node {
        public String name;
        public int year;
        public double weight;

        public Node(String name, int year, double weight) {
            this.name = name;
            this.year = year;
            this.weight = weight;
        }

        @Override
        public String toString() {
            // here you can create your own representation of the object
            String repr = "Name:" + name + ",year:" + year + ",weight:" + weight;
            return repr;
            }
        }

    public static void main(String args[]) {
        Map<String, Node> map = new HashMap<String, Node>();
        Node node1 = new Node("A",1987,70.2);
        Node node2 = new Node("B", 2014, 66.4);
        String key1 = "123";
        String key2 = "345";
        map.put(key1,node1);
        map.put(key2,node2);

        Set<String> keySet= map.keySet();
        for(String x:keySet){
            System.out.println(map.get(x));
        }

       System.out.println(map.get(key1).name); 
    }
}