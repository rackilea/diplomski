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