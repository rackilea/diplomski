import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame {

  public MyFrame() {
    ReactionPanel rp = new ReactionPanel();
    ActionPanel ap = new ActionPanel(rp);
    setLayout(new GridLayout(2, 1));
    add(ap);
    add(rp);
    pack();
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new MyFrame();
      }
    });
  }
}