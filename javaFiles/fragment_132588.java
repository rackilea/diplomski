public static int getInt(Scanner sc, String askMsg, IntPredicate predicate) {
    System.out.println(askMsg);
    int number;
    boolean isIncorrect = true;
    do {
        while (!sc.hasNextInt()) {
            String value = sc.next(); // consuming incorrect token
            System.out.println(value + " is not valid number. Please try again");
        }
        number = sc.nextInt();
        if (!predicate.test(number)) {
            System.out.println(number + " is not valid number. Please try again");
        }else{
            isIncorrect=false;
        }
    } while (isIncorrect);

    return number;
}