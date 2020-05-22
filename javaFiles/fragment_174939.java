Scanner sc = new Scanner(System.in);
do {
    System.out.print("\nInsert a number >>> ");
    try {
        int x = sc.nextInt();
        System.out.println("You inserted " + x);
        if (x > 10 && x < 150) {
            System.out.print("x between 10 and 150: ");
        } else {
            break;
        }
    } catch (InputMismatchException e) {
        System.out.println("x must be an int between 10 and 150");
        sc.nextLine(); //This line is really important, without it you'll have an endless loop as the sc.nextInt() would be skipped. For more infos, see this answer http://stackoverflow.com/a/8043307/1094430
    }
} while (true);