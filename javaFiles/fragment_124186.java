Scanner sc = new Scanner(System.in);
while (true) {
    System.out.println("Input a number to calculate the square of it");
    if (sc.hasNextInt()) {
        int i = sc.nextInt();
        System.out.printf("the square of %d is %d%n", i, i * i);
    } else {
        System.out.println("please input an integer");
        sc.next();
    }
} // while(true)