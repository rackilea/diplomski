import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class TransparentInternalFrame extends JDesktopPane {
   private static final Color COLOR_1 = Color.red;
   private static final Color COLOR_2 = Color.blue;
   private static final float PT_2 = 30f;
   private static final int PREF_W = 800;
   private static final int PREF_H = 500;

   public TransparentInternalFrame() {
      add(new MyInternalFrame("Foo", 50, 50, 300, 300, 0.2f));
      add(new MyInternalFrame("Foo", 400, 100, 300, 300, 0.4f));
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setPaint(new GradientPaint(0, 0, COLOR_1, PT_2, PT_2, COLOR_2, true));
      g2.fillRect(0, 0, getWidth(), getHeight());
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      TransparentInternalFrame mainPanel = new TransparentInternalFrame();

      JFrame frame = new JFrame("TransparentInternalFrame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

@SuppressWarnings("serial")
class MyInternalFrame extends JInternalFrame {
   private AlphaComposite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);

   public MyInternalFrame(String title, int x, int y, int w, int h, final float alpha) {
      super(title);
      setClosable(true);
      setBounds(x, y, w, h);
      setVisible(true);

      int sliderValue = (int) (alpha * 100);
      comp = comp.derive(alpha);
      final JSlider slider = new JSlider(0, 100, sliderValue);
      slider.setMajorTickSpacing(20);
      slider.setMinorTickSpacing(5);
      slider.setPaintLabels(true);
      slider.setPaintTicks(true);
      slider.setBorder(BorderFactory.createTitledBorder("Alpha Value"));
      slider.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent cEvt) {
            float alpha = (float) slider.getValue() / 100f;
            setAlpha(alpha);
            MyInternalFrame.this.repaint();

            Window win = SwingUtilities.getWindowAncestor(MyInternalFrame.this);
            win.repaint();
         }
      });

      add(new JLabel("My Label", SwingConstants.CENTER));
      add(slider, BorderLayout.SOUTH);
   }

   @Override
   public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setComposite(comp);
      super.paint(g);
   }

   public void setAlpha(float alpha) {
      comp = comp.derive(alpha);
   }
}