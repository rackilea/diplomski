package Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Long> outputs = new ArrayList<>();
        table(0, 8, outputs);
    }

    public static void table(int start, int end, List<Long> outputs) {
        outputs.add(fibby(start));
        long lastFibbyOutput = outputs.get(outputs.size() - 1);

        for(int i = outputs.size() - 2; i >= 0; i--) {
            if(outputs.size() == 1) {
                System.out.println(start + " " + lastFibbyOutput); //Always print the first time because it will be a unique value.
                break;
            } else if(outputs.get(i) == lastFibbyOutput) {
                //One of the values matches a previous one, so we break
                break;
            }

            //We're at the end without breaking, so we print.
            if(i == 0) System.out.println(start + " " + lastFibbyOutput);
        }

        if(start == end) {
            return;
        }

        start++;
        table(start, end, outputs);
    }

    public static long fibby(long n) {
        if(n == 0) return 1;

        return (fibby(n/4) + fibby(3 * n / 4));
    }
}