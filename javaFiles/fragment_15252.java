private static int promptAge(Scanner sc) {
    System.out.println("What is you age?");
    for (;;) {
        if (! sc.hasNextInt()) {
            System.out.println("You must enter an number");
        } else {
            int age = sc.nextInt();
            if (age >= 10 && age <= 90)
                return age;
            System.out.println("You age must be within 10 and 90");
        }
        sc.nextLine(); // discard (rest of) line of input
    }
}