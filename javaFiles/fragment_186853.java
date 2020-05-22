Random r = new Random();
while (true) {
    System.out.print("What is the unlock code? ");
    int code = kb.nextInt();
    if (code < 10 || code > 99) {
        System.out.println("Your number must be between 10 and 99");
        continue;
    }

    System.out.println("Picking the lock...");
    System.out.println("");
    int x = -1, counter = 0;
    while (x != code) {
        x = r.nextInt(90) + 10;
        System.out.println(x);
        counter++;
    }
    System.out.println("That took only " + counter
            + " tries to pick the lock!");
    break;
}