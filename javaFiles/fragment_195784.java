import java.util.ArrayList;
import java.util.List;

/**
 * @author mifmif
 * 
 */
public class DFS {

    /**
     * list of generated combination
     */
    List<String> permutations = new ArrayList<String>();
    /**
     * input used to generate combination
     */
    String input = "ABCDEF";
    /**
     * the length of the combination
     */
    int conbinationSize = 3;
    /**
     * isChoosed[i] is true if the combination that is currently prepared
     * contain index.charAt(i)
     */
    boolean[] isChoosed = new boolean[input.length()];

    /**
     * the DFS method that will generate all possible combination
     * 
     * @param partialOutput
     */
    public void generateCombination(String partialOutput) {
        if (partialOutput.length() == conbinationSize) {
            permutations.add(partialOutput);
            return;
        }
        for (int i = 0; i < input.length(); ++i) {
            if (!isChoosed[i]) {
                isChoosed[i] = true;
                generateCombination(partialOutput + input.charAt(i));
                isChoosed[i] = false;
            }
        }

    }

    void printCombination() {
        for (String c : permutations) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        dfs.generateCombination("");
        dfs.printCombination();
    }
}