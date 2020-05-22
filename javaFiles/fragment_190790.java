public Player findClosePlayerInQueue(int rating) {
    long startTime = System.nanoTime();
    int bestDistance = Integer.MAX_VALUE;
    Player res = null;
    for(Player p: queuedPlayers) {
        int dist = Math.abs(p.getRating() - rating);
        if (dist < bestDistance ) {
            bestDistance = dist;
            res = p;
        }
    }
    System.out.printf("Searching took: %.3f", (startTime-System.nanoTime())/1e9);
    return res;
}