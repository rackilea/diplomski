import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.UIManager;

public class TestHitBox {
   public static void main(String[] args) {
      String text = "Hello world! This is Hovercraft!";
      int seconds = 5;
      float composite = 0.85f;
      float points = 48f;
      HitBox.showMessage(text, seconds, composite, points);
   }
}

class HitBox {

   public static void showMessage(final String text, final int seconds, final float composite, final float points) {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager
                     .getSystemLookAndFeelClassName());
            } catch (Exception ex) {
               ex.printStackTrace();
            }
            final JWindow frame = new JWindow();
            frame.setBackground(new Color(0, 0, 0, 0));
            TranslucentPane tp = new TranslucentPane(text, composite, points);
            frame.setContentPane(tp);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            frame.setAlwaysOnTop(true);
            new Timer(1000 * seconds, new TimerListener(frame)).start();
         }
      });
   }
}

class TimerListener implements ActionListener {
   private JWindow frame;

   public TimerListener(JWindow frame) {
      this.frame = frame;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      frame.dispose();
      ((Timer) e.getSource()).stop();
   }
}

@SuppressWarnings("serial")
class TranslucentPane extends JPanel {
   private float composite;

   public TranslucentPane(String s, float composite, float points) {
      this.composite = composite;
      JLabel label = new JLabel(s);
      label.setFont(label.getFont().deriveFont(Font.BOLD, points));
      add(label);
      setOpaque(false); // this breaks a rule
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g.create();
      g2d.setComposite(AlphaComposite.SrcOver.derive(composite));
      g2d.setColor(getBackground());
      g2d.fillRect(0, 0, getWidth(), getHeight());
      g2d.dispose(); // dispose of any graphics we create
   }
}