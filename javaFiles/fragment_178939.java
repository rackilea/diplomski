import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

public class StartingPoint {

   private DrawingArea draw;
   private JButton b1, b2;
   private JPanel userInt;
   private JSpinner gravitySpinner;

   private JPanel mainPanel = new JPanel();

   public StartingPoint() {
      mainPanel.setLayout(new BorderLayout());
      draw = new DrawingArea();
      mainPanel.add(draw, BorderLayout.CENTER);

      userInt = new JPanel();
      mainPanel.add(userInt, BorderLayout.NORTH);

      b1 = new JButton("Start");
      b2 = new JButton("aaa");
      b1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            draw.setUp();
         }
      });
      userInt.add(b1);
      userInt.add(b2);

      SpinnerNumberModel gravityModel = new SpinnerNumberModel(.9, .1, 2, .1);
      gravitySpinner = new JSpinner(gravityModel);
      userInt.add(gravitySpinner);
   }

   public JPanel getMainPanel() {
      return mainPanel;
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            JFrame window = new JFrame("Ball");
            window.add(new StartingPoint().getMainPanel());
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
         }
      });
   }
}

class DrawingArea extends JPanel {

   private static final int PREF_W = 600;
   private static final int PREF_H = 400;

   public void setUp() {
      // TODO finish
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

}