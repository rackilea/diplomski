public void game() {

    Scanner scanner = new Scanner(System.in);

    int time = 10; // sec

    message("You have " + time + " seconds to guess...");
    new Thread(new Background(System.currentTimeMillis() / 1000, time)).start();

    while (true) {
        String s = scanner.next();

        if (s.equals("55")) {
            message("You win");
            System.exit(0);
        } else {
            message("try again...");
        }
    }

}

private void message(String str) {
    System.out.println(str);
    System.out.print("> "); // monit
}