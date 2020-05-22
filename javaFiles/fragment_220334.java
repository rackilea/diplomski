public static void main(String[] args) {
    Feet2Inches converter = new Feet2Inches();
    if (args.length != 3) {
        System.err.println("Missing arguments! give me three numbers");
        System.exit(1);//error exit
    }
    int val1 = Integer.valueOf(args[0]);
    int val2 = Integer.valueOf(args[1]);
    double val3 = Double.valueOf(args[1]);
    int max = converter.max(val1, val2);
    double inches = converter.feetToInches_(val3);
    System.out.println("Max value from (" + val1 + "," + val2 + ")= " + max);
    System.out.println(val3 + "Feet = " + inches + " inches");
}