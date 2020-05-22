static void reset() {
    timer.cancel();
    isPaused = false;

    genNumber = 1;
    header = new JPanel();
    body = new CellGrid();
    body.repaint();

    timer = new Timer();
    timer.schedule(new GameStep(), 0,1000);
}