public static double calculatePrice(int type, double gallons) {
    double result = 0;
    switch (type) {
        case 1:
            result = gallons * 2.19;
        break;
        case 2:
            result = gallons * 2.49;
        break;
        case 3:
            result = gallons * 2.71;
        break;
        case 4:
            result = gallons * 2.99;
    }
    System.out.printf("You owe: %.2f", result);
    return result;
}