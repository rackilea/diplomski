class StringExercise {
    static void possibleStrings(char[] alphabet, PrintWriter pw, char[] curr, int index) {
        if (index == curr.length) {
            pw.println(curr);
            return;
        }
        for (char c : alphabet) {
            curr[index] = c;
            possibleStrings(alphabet, pw, curr, index + 1);
        }
    }
}

public class Combos {
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        try (PrintWriter pw = new PrintWriter("combos.txt")) {
            StringExercise.possibleStrings("01234abcde".toCharArray(), pw, new char[5], 0);
        }
        System.out.printf("Took %.3f seconds to run%n", (System.currentTimeMillis()-start)/1e3);
    }
}