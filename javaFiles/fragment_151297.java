public class Main {
  public static void main(String[] args) {
    // Kick off code to build and display UI on Event Dispatch Thread.
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame("UIPanel Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Add UIPanel to JFrame.  Using CENTER layout means it will occupy all
        // available space.
        frame.add(new UIPanel(), BorderLayout.CENTER);

        // Explicitly set frame size.  Could use pack() instead.
        frame.setSize(800, 600);

        // Center frame on the primary display.
        frame.setLocationRelativeTo(null);

        // Finally make frame visible.
        frame.setVisible(true);
      }
    });
  }
}