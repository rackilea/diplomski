public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("Flappy bird");
    frame.setSize(1200, 800);
    //FlappyBird game = new FlappyBird();
    Canvas game = new Canvas();
    frame.getContentPane().setBackground(Color.YELLOW);
    frame.add(game);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.setResizable(false);
    // while (true) {
    //         game.moveBall();
    //         game.gameOver();
    //         game.moveRect();
    //         game.repaint();
    //         Thread.sleep(14);
    // }
}