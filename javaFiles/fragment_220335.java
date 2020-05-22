public static void main(String[] args) {
    Feet2Inches converter = new Feet2Inches();
    Scanner input = new Scanner(System.in);
    System.out.print("Argument 1:");
    int val1 = input.nextInt();
    System.out.print("Argument 2:");
    int val2 = input.nextInt();
    System.out.print("Argument 3:");
    double val3 = input.nextDouble();
    int max = converter.max(val1, val2);
    double inches = converter.feetToInches_(val3);
    System.out.println("Max value from (" + val1 + "," + val2 + ")= " + max);
    System.out.println(val3 + "Feet = " + inches + " inches");
}