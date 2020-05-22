public static void main(String[] args) {
    boolean accepted = false;
    Scanner scan = new Scanner(System.in);
    Pattern pattern = Pattern.compile("^[a-zA-Z]$");
    int total = 0;
    while (!accepted) {
        System.out.println("Enter 3 a-z characters");
        for (int i = 0; i < 3; i++) {
            String input = scan.next();
            while (!pattern.matcher(input).matches()) {
                System.out.println("Incorrect");
                input = scan.nextLine();
            }
            int letter = input.charAt(0);
            if (letter >= 97 && letter <= 122) {
                total += letter - 96;
            } else if (letter >= 65 && letter <= 90) {
                total += letter + 36;
            }
        }

        if (total % 5 == 0) {
            System.out.println("accepted");
            accepted = true;
            scan.close();
        } else {
            System.out.println("not accepted");
            total = 0;
        }
    }
}