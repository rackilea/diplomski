import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OccuranceCounter {

    public static void main(String[] args) {

        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number or -1 to quit");
        while (input.hasNext()) {
            int x = input.nextInt();
            if (x >= 0 && x <= 50){
                Integer val = counter.get(x);
                if(val == null){
                    counter.put(x, 1);
                } else {
                    counter.put(x, ++val);
                }
            } else if(x == -1){
                break;
            }
        }

        for(Integer key : counter.keySet()){
            System.out.println(key + " occured " + counter.get(key) + " times");
        }
    }

}