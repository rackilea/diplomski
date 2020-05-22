Scanner in = new Scanner(System.in);
final int NUM_ELEMENTS = 5;
double[] userVals = new double[NUM_ELEMENTS];
System.out.println("Enter five numbers.");
System.out.println();
double min = Double.POSITIVE_INFINITY;
double max = Double.NEGATIVE_INFINITY;
for (int i = 0; i < NUM_ELEMENTS; i++) {
    System.out.println("Enter next number: ");
    userVals[i] = in.nextDouble();
    min = Math.min(min, userVals[i]);
    max = Math.max(max, userVals[i]);
}
System.out.println("Max number: " + max);
System.out.println("Min number: " + min);