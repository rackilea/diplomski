while(gamePanel.player == null) {
    try {
        Thread.sleep(10);
    }
    catch (InterruptedException e) {}
}