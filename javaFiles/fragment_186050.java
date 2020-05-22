Thread t = new Thread(() -> {
    Scanner s = new Scanner(System.in);
    while (true) {
        lines.add(s.nextLine());
    }
});
t.setDaemon(true); // so that this thread doesn't hang at the end of your program
t.start();