package package2;

import package1.Data;
import package1.Solution;

public class App {
    public static void main(String[] args) throws Exception {
        Data input = new Data();

        input.s = "ipsum";
        input.a1 = 1;
        input.a2 = 2;

        Solution solution = new Solution();
        Data result = solution.returnValue(input);

        // use result
    }
}