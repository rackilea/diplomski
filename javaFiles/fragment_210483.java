import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.lang.reflect.InvocationTargetException;

    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.JProgressBar;
    import javax.swing.SwingUtilities;
    import javax.swing.Timer;

    public class ProgressDemo extends JPanel {
       JProgressBar bar        = new JProgressBar();
       JFrame       frame      = new JFrame();
       int          n          = 0;
       int          panelCount = 0;
       JPanel       subPanel   = new JPanel();

       public ProgressDemo() {
          setPreferredSize(new Dimension(500, 500));
          subPanel.setPreferredSize(new Dimension(500, 450));
          frame.add(this);
          add(bar);
          add(subPanel);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
          Timer timer = new Timer(0, new MyActionListener());
          timer.setDelay(200);
          bar.setMaximum(200);

          timer.start();

       }
       public static void main(String[] args) {
          new ProgressDemo().start();
       }
       public void start() {
          for (int i = 0; i < 200; i++) {
             try {
                SwingUtilities.invokeAndWait(() ->
                {
                   subPanel.add(new MyPanel());
                   revalidate();
                   frame.repaint();
                });
                 sleep(500);
             }
             catch (InvocationTargetException | InterruptedException ite) {
                ite.printStackTrace();
             }
          }
       }

       public static void sleep(int milli) {
          try {
             Thread.sleep(milli);
          }
          catch (InterruptedException ie) {
          }
       }

       private class MyActionListener implements ActionListener {
          public void actionPerformed(ActionEvent ae) {
             n++;
             if (n > 200) {
                  n = 0;
             }
             bar.setValue(n);
          }
       }

       Color[] colors = {
             Color.red, Color.blue, Color.green, Color.yellow, Color.cyan,
             Color.magenta
       };

       class MyPanel extends JPanel {
          public MyPanel() {
             setBackground(colors[panelCount % colors.length]);
             int w = 25;
             int h = 25;
             setPreferredSize(new Dimension(w, h));
             panelCount++;
             setVisible(true);
          }

       }
    }