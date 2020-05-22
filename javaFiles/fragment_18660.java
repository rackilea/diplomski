public class ImageLoad extends JFrame {

   public ImageLoad() {
      setSize(800, 800);
      JPanel panel = new JPanel();
      ImageIcon icon = new ImageIcon("singer.jpg");
      JLabel label = new JLabel();
      label.setIcon(icon);
      panel.add(label);
      add(panel);
   }

   public static void main(String[] args) {
      new ImageLoad().setVisible(true);
   }
}