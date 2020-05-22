import java.net.*;
import javax.swing.*;

public class TransparentIconTest {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
      try {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(
            new URL("http://i.stack.imgur.com/AnvwU.png"));
        f.setIconImage(icon.getImage());
        f.setSize(320, 240);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
  }
}