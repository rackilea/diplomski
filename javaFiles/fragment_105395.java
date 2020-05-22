public void run() {
    while(running) {
        // Render, update etc...
    }
}

// The main method
public static void main(String[] args) {
    // Create a new instance of Game and start it
    Game game = new Game().create();
    game.stop();
}