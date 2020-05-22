import java.util.*;

public class Sandbox {
    private Map<Integer, List<Integer>> positions;
    private int[] input;

    public static void main(String[] args) {
        (new Sandbox()).run();
    }

    public Sandbox() {
        positions = new HashMap<Integer, List<Integer>>();
        input = new int[] { 1,2,3,2,2,3,1,3,2 };
    }

    private void run() {
        for(int i = 0; i < input.length; i++) {
            Integer value = input[i];

            if(positions.containsKey(value)) {
                List<Integer> list = positions.get(value);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                positions.put(value, list);
            }
        }

        for(Integer key : positions.keySet()) {
            System.out.println("Value: " + key);
            System.out.println("----------");
            for(Integer position : positions.get(key)) {
                System.out.println("Position: " + position);
            }
            System.out.println();
        }
    }
}