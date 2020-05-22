Scanner in = new Scanner(System.in);

try {
    String num = in.nextLine();

    if (num.length() < 8 || num.length() > 9) {
        System.out.println("it was invalid");
        return;
    }

    char check = num.charAt(7);

    if (check < 'A' || check > 'Z') {
        System.out.println("it was invalid");
        return;

    } else if (num.length() == 9) {
        check = num.charAt(8);

        if (check < 'A' || check > 'Z') {
            System.out.println("it was invalid");
            return;
        }
    }

    for (int i = 0; i < 7; i++) {
        check = num.charAt(i);

        if (check < '0' || check > '9') {
            System.out.println("it was invalid");
            return;
        }
    }

    System.out.println("it was valid");

} finally {
    in.close();
}