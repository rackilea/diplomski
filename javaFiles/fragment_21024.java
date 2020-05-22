public static String increment(String number) {
    char[] cars = number.toUpperCase().toCharArray();
    for (int i = cars.length - 1; i >= 0; i--) {
        if (cars[i] == 'Z') {
            cars[i] = 'A';
        } else if (cars[i] == '9') {
            cars[i] = '0';
        } else {
            cars[i]++;
            break;
        }
    }
    return String.valueOf(cars);
}