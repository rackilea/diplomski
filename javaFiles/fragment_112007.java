public static void main(String[] args) throws Exception {
    String birthday = "01091995";
    int[] digits = Arrays.stream(birthday.split("")).mapToInt(Integer::parseInt).toArray();
    recursiveFunction(digits);
}

private static void recursiveFunction(int[] digits) {
    if(digits.length == 1) {
        // Base Case
        System.out.println(digits[0]);
    } else {
        // Recursive Case
        System.out.println(Arrays.toString(digits));
        int[] digitsProcessed = new int[digits.length -1];
        for (int i = 0; i < digits.length - 1; i++) {
            digitsProcessed[i] = digits[i] + digits[i+1]; // Logic
        }
        recursiveFunction(digitsProcessed);
    }
}