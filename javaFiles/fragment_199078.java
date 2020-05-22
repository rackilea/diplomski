public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (writeAndCheckEven(Integer.parseInt(scanner.nextLine()))) {
        System.out.println("You added an even number, go on");
    }

    System.out.println("You added an odd number, done!");
}

private static boolean writeAndCheckEven(int number) {
    return number % 2 == 0;
}