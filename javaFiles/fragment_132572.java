import java.awt.*;
import java.math.*;
import javax.swing.*;
public class JSpinnerBug2 {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          JFrame frame = new JFrame();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.getContentPane().add(new JSpinnerBug2().makeUI());
          frame.setSize(320, 240);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
  public JComponent makeUI() {
    Box box = Box.createVerticalBox();
    box.add(new JSpinner(new SpinnerNumberModel(2.01, 2.00, 6.00, 0.01)));
    box.add(Box.createVerticalStrut(10));
    box.add(new JSpinner(new SpinnerNumberModel(29.7f, 29.6f, 111.8f, 0.1f)));
    box.add(Box.createVerticalStrut(10));
    box.add(new JSeparator());

    //TEST:
    double d = 29.7 - 29.6 - 0.1;
    System.out.format("(%f-%f-%f>=0): %b%n", 29.7, 29.6, 0.1, d>=0);
    System.out.format("(abs(%f-%f-%f)<1.0e-14): %b%n", 29.7, 29.6, 0.1, Math.abs(d)<1.0e-14);
    System.out.format("(abs(%f-%f-%f)<1.0e-15): %b%n", 29.7, 29.6, 0.1, Math.abs(d)<1.0e-15);

    box.add(new JSpinner(new SpinnerNumberModel(2.01f, 2.00f, 6.00f, 0.01f)));
    box.add(Box.createVerticalStrut(10));
    box.add(new JSpinner(new SpinnerNumberModel(29.7, 29.6, 111.8, 0.1) {
      @Override public Object getPreviousValue() {
        Number v = getNumber();
        BigDecimal value    = new BigDecimal(v.toString());
        BigDecimal stepSize = new BigDecimal(getStepSize().toString());
        BigDecimal maximum  = new BigDecimal(getMaximum().toString());
        BigDecimal minimum  = new BigDecimal(getMinimum().toString());
        BigDecimal newValue;
        if (v instanceof Double) {
          newValue = value.subtract(stepSize);
        } else {
          return super.getPreviousValue();
        }
        if ((maximum != null) && (maximum.compareTo(newValue) < 0)) {
          return null;
        }
        if ((minimum != null) && (minimum.compareTo(newValue) > 0)) {
          return null;
        } else {
          return newValue;
        }
      }
    }));
    box.add(Box.createVerticalGlue());
    box.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    return box;
  }
}