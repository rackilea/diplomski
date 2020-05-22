public static void main(String[] args) {
  SwingUtilities.invokeLater(() -> {

    JFrame frame = new JFrame();
    frame.setSize(640, 480);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Remove border of JFrame
    frame.setUndecorated(true);
    // Set location in center
    frame.setLocationRelativeTo(null);
    // Set a transparent background
    frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0f));

    BackgroundPane panel = null;
    try {
      panel = new BackgroundPane(Toolkit.getDefaultToolkit().getImage(new URL(
              "http://www.shiaupload.ir/images/77810787432153420049.png")));
      panel.setOpaque(false);
    } catch (MalformedURLException ex) {
      System.out.println(ex);
      return;
    }
    frame.add(panel);
    setUI(panel);

    frame.setVisible(true);
  });
}