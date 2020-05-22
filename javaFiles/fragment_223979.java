import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        One one = new One();
        Two two = new Two();
        one.functionOne(two);
        two.functionTwo();

    }

    static class One {

        public void functionOne(Two obj2) {
                Map<Integer, String> map = new LinkedHashMap<Integer, String>();
            for (int i = 0; i < 10; i++) {
                map.put(i, "one");
                obj2.pushData(map);
            }
        }

    }

    static class Two {

        Queue queue = new LinkedList();

        public void pushData(Map<Integer, String> map) {
            queue.add(map);
        }

        public void functionTwo() {
            System.out.println("Data:" + queue.size());
            while (queue.size() > 0) {
                System.out.println("Data:" + queue.poll());
                // Here I have also used queue.remove();
            }
        }
    }

}