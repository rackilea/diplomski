public static double approximateSqrt(double number) {
    double low = 0;
    double high = 0;
    double midPoint;
    double midPointSqr;
    final double EPSILON = .000001;

    if (number < 0) {
        System.out.printf("The square root of %f is NaN%n", number);
        return Double.NaN;
    } else if (number < 1) {
        low = 0;
        high = 1;
    } else {
        low = 1;
        high = number;
    }
    midPoint = (low + high) / 2;
    midPointSqr = (midPoint * midPoint);

    while (Math.abs(midPointSqr - number) >= EPSILON) {
        System.out.printf("[%.6f, %.6f]%n", low, high);

        if (midPointSqr > number) {
            high = midPoint;
        } else {
            low = midPoint;
        }

        midPoint = (low + high) / 2;
        midPointSqr = (midPoint * midPoint);
    }
    System.out.printf("Final. midpoint=%.6f num=%.6f%n", midPoint, number);
    return midPoint;
}

public static void main(String[] args) {
    System.out.println("Enter a number to find its square root -> ");
    Scanner cin = new Scanner(System.in);
    double number = cin.nextDouble();
    approximateSqrt(number);
}