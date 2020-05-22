import java.util.Arrays;

public abstract class Main {
    int max = 4;
    int min = 2;

    public static void main(String args[]) {
        new Main() {
            public void element(char[] result, int offset, int length) {
                System.out.println(new String(result, offset, length));
            }
        }.generate("ABCD");
    }

    private void generate(char[] input) {
        char[] result = new char[input.length];
        int[] index = new int[input.length];

        // initialize the arrays.
        Arrays.fill(result, 0, result.length, input[0]);
        Arrays.fill(index, 0, index.length, 0);

        // loop over the output lengths.

        for (int length = min; length <= max; length++) {
            int updateIndex = 0;
            do {
                element(result, 0, length);

                // update values that need to reset.
                for (updateIndex = length - 1;
                     updateIndex != -1 && ++index[updateIndex] == input.length;
                     result[updateIndex] = input[0], index[updateIndex] = 0, updateIndex--)
                    ;

                // update the character that is not resetting, if valid
                if (updateIndex != -1) result[updateIndex] = input[index[updateIndex]];
            }
            while (updateIndex != -1);
        }
    }

    void generate(String input) {
        generate(input.toCharArray());
    }

    public abstract void element(char[] result, int offset, int length);
}