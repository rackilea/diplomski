public static void main(String args[]) {
    int number1, number2, choice, sum, product;
    operations myoperations = new operations();
    Scanner scan = new Scanner(System.in);
    while (true) {
        System.out.println("\n1. Get numbers");
        System.out.println("\n2. Addition");
        System.out.println("\n3. Multiplication");
        System.out.println("\n4. Exit");
        choice = scan.nextInt();

        switch (choice) {
        case 1:
            System.out.println("enter the two numbers:");
            number1 = scan.nextInt();
            number2 = scan.nextInt();
            myoperations.getnumbers(number1, number2);
            break;
        case 2:
            myoperations.addnumbers();
            break;
        case 3:
            myoperations.multiplynumbers();
            break;
        case 4:
            System.exit(0);
            break;
        }
    }
}