while (true) {
    System.out.println("Enter the next value of your queue");
    input = A1.nextLine();
    if ("-1".equals(input)) {
        break;
    }
    Q.enqueue(input);
}