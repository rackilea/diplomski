public static void main(String[] args) {
    int[] values = new int[] { 1, 5, 2, 6, 3, 7, 4, 8 };

    double sum = 0;
    for (int value : values)
        sum += value;

    double avg = sum / values.length;

    System.out.printf("AVG = %.2f\n----------\n", avg);

    for (int value : values) {
        if (value > avg)
            System.out.println(value);
    }
}