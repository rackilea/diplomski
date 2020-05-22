import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.synth.*;

public class SynthButtonTest {
  public JComponent makeUI() {
    JPanel p = new JPanel();
    p.add(new JButton("JButton1"));
    p.add(new JButton("JButton2"));
    p.add(new JButton("JButton3"));
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      try {
        Class<?> c = SynthButtonTest.class;
        SynthLookAndFeel synth = new SynthLookAndFeel();
        synth.load(c.getResourceAsStream("button.xml"), c);
        UIManager.setLookAndFeel(synth);
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new SynthButtonTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}