... main(...) {
  SwingUtilities.invokeLater(new Runnable() {
      public void run() {
          GUI gui= new GUI();
          gui.setVisible(true); // and other stuff
      }
  });
}