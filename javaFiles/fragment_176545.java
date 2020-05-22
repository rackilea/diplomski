public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<Double> inputs = getALInfo(in);
    int lowNum = getLowestnum(in);
    double average = calculateAvg(inputs, lowNum);
    System.out.printf("%.2f%n", average);
}