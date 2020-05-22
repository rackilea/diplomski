Scanner scanner = new Scanner("33 4 / 44 2 - ^");
while (scanner.hasNext()) {
    if (scanner.hasNextInt()) {
        int nextInt = scanner.nextInt();
        System.out.println(nextInt);
    } else {
        // discard next token
        scanner.next();
    }
}