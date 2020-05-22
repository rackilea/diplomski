import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<int[]> solutions = generate(3, 1, 4);
        for(int[] c: solutions) {
            System.out.println(Arrays.toString(c));
        }
    }  

    public static List<int[]> generate(int target, int max, int n) {
        return generate(new ArrayList(), new int[0], target, max, n);
    }

    private static List<int[]> generate(List<int[]> solutions, 
            int[] current, int target, int max, int n) {        
        int sum = Arrays.stream(current).sum();
        if (current.length == n) {
            if (sum == target) {
                solutions.add(current);
            }
            return solutions;
        }
        if (sum > target) {
            return solutions; 
        }
        for(int i=0; i <= max; i++) {
            int[] next = Arrays.copyOf(current, current.length + 1);
            next[current.length] = i; 
            generate(solutions, next, target, max, n);
        }
        return solutions; 
    }
}