public class Popup {
  public static void main(String[] args) {
      JFrame window = new JFrame("Title");

      window.add(new JLabel("North", JLabel.CENTER), BorderLayout.NORTH);
      window.add(new JLabel("South", JLabel.CENTER), BorderLayout.SOUTH);
      window.add(new JLabel("West"),  BorderLayout.WEST);
      window.add(new JLabel("East"),  BorderLayout.EAST);

      JPanel centerPanel = new JPanel();
      centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

      centerPanel.add(new JLabel("Here"));
      centerPanel.add(new JLabel("Here"));
      centerPanel.add(new JLabel("Here"));
      centerPanel.add(new JLabel("Here"));

      window.add(centerPanel, BorderLayout.CENTER);

      window.setSize(600, 400);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
   }
}