if (imaginaryCheck > 0) {
    double plus = (-b + Math.sqrt(imaginaryCheck)) / (2 * a);
    double minus = (-b - Math.sqrt(imaginaryCheck)) / (2 * a);

    System.out.format("Your first solution is: %1.2f\n", plus);
    System.out.format("Your second solution is: %1.2f", minus);
} else if (imaginaryCheck == 0) {
    double plus = -b / (double) (2 * a);

    System.out.format("Your only solution is: %1.2f\n", plus);
} else {
    double plusReal = -b / (double) (2 * a);
    double plusImaginary = Math.sqrt(-1 * imaginaryCheck) / (2 * a);

    System.out.format("Your first solution is: %1.2f + %1.2fi\n", plusReal, plusImaginary);
    System.out.format("Your second solution is: %1.2f - %1.2fi", plusReal, plusImaginary);
}