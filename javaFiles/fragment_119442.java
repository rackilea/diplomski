public static void main(String[] args) {
    int num1, i;
    String choice;
    Scanner Scan = new Scanner(System.in);

    do {
        do {
            System.out.print("Enter a number between 20 and 30 ---> ");
            num1 = Scan.nextInt();
        } while (num1 > 30 || num1 < 20);

        for (i = num1; i >= 20; i--) {

            System.out.print(i + " ");
        }

        System.out.println("");
        choice = Scan.next();
    }
    while (choice.equals("yes"));
}