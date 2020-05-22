public static void main(String[] args) {
    int fileNumber = Integer.parseInt(args[0]);
    int delay = Integer.parseInt(args[1]);

    for (int i=1; i <= fileNumber; ++i) {
        String filename = "/some/path/to/input" + i + ".txt";
        Q2fix ks = new Q2fix(filename);
        ks.fill();
        Thread.sleep(delay);
    }
}