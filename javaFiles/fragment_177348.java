public static void main(String[] args) {
    double[] numbers = new double[3];
    for (int i = 0; i < 3; i++) {
        numbers[i] = Double.parseDouble(args[i]);
    }
    Arrays.sort(numbers);
    ...
}