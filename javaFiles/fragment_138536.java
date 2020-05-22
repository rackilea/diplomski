public static void main(String[] args) throws ParseException {
    int y = 333;// if y is 777 i am getting blank
    int sum = 0;
    while (y % 10 != 0) {
        sum += y %10;
        y = y / 10;
        if (0 == y && sum >= 10) {
            y = sum;
            sum = 0;
        }
    }
    System.out.println(sum);
}