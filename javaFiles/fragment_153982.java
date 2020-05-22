public class SpaceGame extends JPanel implements ActionListener {
  //The list of spaceships that should be painted

  LinkedList<Spaceship> playingList = new LinkedList<Spaceship>();
  Timer t = new Timer(5, this);

  public void start() {
    if (t.isRunning()) {
      return;
    }
    t.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ListIterator<Spaceship> iter = playingList.listIterator();
    while (iter.hasNext()) {
      Spaceship s = iter.next();
      s.moveSpaceship();

    }
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Spaceship s : playingList) {
      s.drawSpaceship(g);
    }
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        SpaceGame game = new SpaceGame();
        JFrame fr = new JFrame();
        fr.setTitle("SPACE GAME");
        // This is unadvisable :/
        fr.setSize(990, 690);
        fr.add(game);

        game.playingList.add(new Spaceship(3, 0, 570));
        game.playingList.add(new Spaceship(1, 250, 570));
        game.playingList.add(new Spaceship(2, 500, 570));

        JButton start = new JButton("START");
        start.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(java.awt.event.ActionEvent e) {
            game.start();
          }
        });
        fr.add(start, BorderLayout.SOUTH);

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    });
  }
}