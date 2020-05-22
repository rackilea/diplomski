public static int[] highdef(int[] input) {
    int[] result = new int[input.length * 3 - 2];

    for (int i = 0; i < input.length - 1; i++) {
        result[i * 3] = input[i];
        result[i * 3 + 1] = input[i] + (Math.abs(input[i + 1] - input[i]) / 3);
        result[i * 3 + 2] = input[i] + (Math.abs(input[i + 1] - input[i]) / 3) * 2;
    }
    result[result.length - 1] = input[input.length - 1];
    return result;
}