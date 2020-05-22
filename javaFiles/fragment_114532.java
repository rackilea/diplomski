public static void calculateMetricBMI() {
    double weightKG = getWeight();
    double heightCM = getHeight();

    System.out.println("A body mass index of 20-25 is considered \"normal\"");
    double bmiMetric = weightKG/Math.pow(heightCM/100.0, 2);
    System.out.print("Your BMI is " + bmiMetric);
} 

public static double getWeight() {
    Scanner input = new Scanner(System.in);
    // Input Weight
    System.out.println("Enter your weight in kilograms: ");
    double weightKG = input.nextInt();

    return weightKG;
}

public static double getHeight() {
    Scanner input = new Scanner(System.in);
    // Input Height
    System.out.println("Enter your height in centimeters: ");
    double heightCM = input.nextInt();

    return heightCM;
}