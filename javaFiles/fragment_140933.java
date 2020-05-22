public static void main(String[] args) {
   SwingUtilities.invokeLater(new Runnable() {
    public void run() {
    Gui g = new Gui();
    g.initalizeGUI();
    Gui.setVisible(true);
  }
  });
}