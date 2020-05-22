import java.awt.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public final class MaskFormatterTest {
  private Component makeUI() {
    String mask = "##/##/##";
    JFormattedTextField field = new JFormattedTextField(createFormatter(mask));
    field.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    field.setText("031618");

    JPanel p = new JPanel(new GridLayout(2, 1, 10, 10));
    p.add(field);
    p.add(new JTextField("03/16/18"));

    JPanel panel = new JPanel(new BorderLayout());
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.add(p, BorderLayout.NORTH);
    return panel;
  }
  protected static MaskFormatter createFormatter(String s) {
    MaskFormatter formatter = null;
    try {
      formatter = new MaskFormatter(s);
    } catch (ParseException ex) {
      System.err.println("formatter is bad: " + ex.getMessage());
    }
    return formatter;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new MaskFormatterTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}