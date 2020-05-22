public void create () throws InterruptedException {

    JFrame frame = new JFrame("Mini Tennis");
    GameMain gamemain = new GameMain();
    frame.add(gamemain);
    frame.setSize(350, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    (new Thread() {
    public void run() {
        while (true) {
            gamemain.move();
            gamemain.repaint();
            Thread.sleep(10);
        }
    }
    ).start();
}