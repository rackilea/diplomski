public Main()
{
    frame.setSize(SIZE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    GamePanel panel = new GamePanel();
    frame.add(panel);
    frame.setResizable(false);
    frame.setFocusable(true);
    frame.addKeyListener(panel);
}