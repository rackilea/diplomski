private static int posNum(Scanner scan) {
    int input = 0;
    boolean error = false;
    if (scan.hasNext()) {
        if (scan.hasNextInt()) {
            input = scan.nextInt();
            error = input <= 0;
        } else {
            scan.next();
            error = true;
        }
    }
    while (error) {
        System.out.print("Invalid input. Please reenter: ");
        if (scan.hasNextInt()) {
            input = scan.nextInt();
            error = input <= 0;
        } else {
            if (scan.hasNext())
                scan.next();
            error = true;
        }
    }
    return input;
}