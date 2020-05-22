public class MultipleOfThreeInAnArray {
    public static void choseMultiplesOfThree(int[] input) {
        int[] output = new int[input.length];
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 3 == 0) {
                output[index++] = input[i];
            }
        }
        System.out.println(Arrays.toString(output));
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 5, 6, 9, 30};
        choseMultiplesOfThree(input);
    }
}