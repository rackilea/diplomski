private void gameStart() {
    if (!game.isGameRunning()) {
        game.start();
        sendMessage("Game started");
    }
}