import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.*;

public class PasswordCharacterTest {
  public JComponent makeUI() {
    //@see com/sun/java/swing/plaf/windows/WindowsLookAndFeel.java
    //"PasswordField.echoChar", new XPValue(new Character((char)0x25CF), new Character('*')),
    JPasswordField pf1 = new JPasswordField(24);
    pf1.setEchoChar('\u25CF');
    JPasswordField pf2 = new JPasswordField(24) {
      @Override public void updateUI() {
        super.updateUI();
        setUI(MyPasswordFieldUI.createUI(this));
      }
    };
    JPanel p = new JPanel();
    p.add(pf1);
    p.add(pf2);
    p.setBorder(BorderFactory.createEmptyBorder(20, 5, 10, 5));
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new PasswordCharacterTest().makeUI());
      f.setSize(320, 240);
      f.setResizable(false);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class MyPasswordFieldUI extends BasicPasswordFieldUI {
  public static MyPasswordFieldUI createUI(JPasswordField c) {
    //TEST: c.setEchoChar('W');
    c.setEchoChar('O');
    return new MyPasswordFieldUI();
  }
  @Override public View create(Element elem) {
    return new MyPasswordView(elem);
  }
  private static class MyPasswordView extends PasswordView {
    @Override protected int drawEchoCharacter(Graphics g, int x, int y, char c) {
      Graphics2D g2 = (Graphics2D) g.create();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                          RenderingHints.VALUE_ANTIALIAS_ON);
      FontMetrics fm = g2.getFontMetrics();
      int r = fm.charWidth(c) - 2;
      g2.setPaint(Color.RED);
      g2.fillOval(x + 1, y + 3 - fm.getAscent(), r, r);
      g2.dispose();
      return x + fm.charWidth(c);
    }
    protected MyPasswordView(Element element) {
      super(element);
    }
  }
}