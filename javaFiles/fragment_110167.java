try {
    selection = scanner.nextInt();
} catch (Exception e) {
    selection = -1;
    scanner.next(); // discard the input
}