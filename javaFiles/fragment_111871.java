public class MultipleOfThreeInAnArray {
    public static void choseMultiplesOfThree(int[] input) {
        List<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 3 == 0) {
                output.add(input[i]);
            }
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 5, 6, 9, 30};
        choseMultiplesOfThree(input);
    }
}