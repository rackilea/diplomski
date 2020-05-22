public void readFile(Scanner in) {
    Scanner inScanner = new Scanner(System.in); // <-- remove this line
    Queue<PlayListTrack> queue = new LinkedList<PlayListTrack>();

    while (in.hasNext()) {

        queue.add(new SimpleMusicTrack(in.nextLine(), in.nextLine(), in
                .nextLine()));
    }
    inScanner.close(); // <--- remove this line
}