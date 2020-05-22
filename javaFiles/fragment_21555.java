private static void createAndShowGUI() {

  game.addComponentToPane(frame.getContentPane());
  frame.setResizable(false);      
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  frame.pack();

  if(frame.getContentPane().getWidth() > 600){
        frame.pack();
  }

  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
}