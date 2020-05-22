public static void main(String[] args) throws Exception {
    String[] letters = {"x", "y", "z"};
    int[] numbers = {2, 3, 4};

    String[] result = bigArr(letters, numbers);

    // prints [x, y, z, xx, yyy, zzzz]
    System.out.println(Arrays.toString(result));
}

private static String[] bigArr(String[] letters, int[] numbers) {
    int lettersLength = letters.length;
    int numbersLength = numbers.length;

    String[] result = new String[lettersLength + numbersLength];

    for (int n = 0; n < lettersLength; ++n) {
        result[n] = letters[n];
    }

    StringBuilder sb = new StringBuilder();
    for (int n = lettersLength; n < result.length; ++n) {
        sb.setLength(0); // reset the StringBuilder

        for (int m = 0; m < numbers[n - lettersLength]; ++m) {
            sb.append(letters[n - lettersLength]);
        }

        result[n] = sb.toString();
    }

    return result;
}