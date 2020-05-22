import javax.swing.*;
import java.awt.*;

public class LimitValueSpinner{
  public static void main(String[] args){
  JFrame frame = new JFrame("Limiting value for a JSpinner");
  SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1); //default value,lower bound,upper bound,increment by
  JSpinner spinner = new JSpinner(sm);
  JPanel panel = new JPanel();
  panel.add(spinner);
  frame.add(panel, BorderLayout.NORTH);
  frame.setSize(400, 400);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}