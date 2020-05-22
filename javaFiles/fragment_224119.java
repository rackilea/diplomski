public static void main(String[] args) {
    int operator;
    double result;
    boolean ask = true;
    Scanner numberScanner = new Scanner(System.in);
    while (ask) {

        System.out.println(
                "please select your operator:\n" + "1 for +\n" + "2 for -\n" + "3 for *\n" + "4 for %\n" + "");
        operator = numberScanner.nextInt();
        System.out.println("you chose " + operator + " operator babe");

        // Here was your "Mistake". You instantly started asking the user for another input,
        // but actually wanted to ahve the switch statment here

        switch (operator) {
        case 1:
            result = get_num1(numberScanner) + get_num2(numberScanner);
            System.out.println("result is:" + result);
            break;
        case 2:
            result = get_num1(numberScanner) - get_num2(numberScanner);
            System.out.println("result is:" + result);
            break;
        case 3:
            result = get_num1(numberScanner) * get_num2(numberScanner);
            System.out.println("result is:" + result);
            break;
        case 4:
            result = get_num1(numberScanner) % get_num2(numberScanner);
            System.out.println("result is:" + result);
            break;
        default:
            System.out.println("you chosen the wrong operator babe :)");
            break;

        }

        System.out.println("do yo want to continue?\n" + "y for yes\n" + "n for no\n");
        char askInput = numberScanner.next().charAt(0);
        if (askInput == 'n')
            ask = false;
    }
}

public static double get_num1(Scanner scanner) {
    System.out.println("please enter your first number");
    return scanner.nextDouble();
}

public static double get_num2(Scanner scanner) {
    System.out.println("please enter your second number");
    return scanner.nextDouble();
}