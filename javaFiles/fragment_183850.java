public static void main(String[] args) {
    Scanner scanner = new Scanner("123 abc 456");
    while (scanner.hasNext()) {
        try {
            int age = scanner.nextInt();
            System.out.println("Found int: " + age);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. age must be a number.");
            String s = scanner.next();
            System.out.println("Skipping: " + s);
        }
    }
}