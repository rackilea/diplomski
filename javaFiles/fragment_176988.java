import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;

public class GradientTranslucentWindow extends JFrame {
public GradientTranslucentWindow() {
    super("GradientTranslucentWindow");

    initComponents();
    jPanel1.setOpaque(false);
    setBackground(new Color(0,0,0,0));
    setSize(new Dimension(300,200));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel() {

        @Override
        protected void paintComponent(Graphics g) {
            if (g instanceof Graphics2D) {

                final int R = 240;
                final int G = 240;
                final int B = 240;

                Paint p =
                    new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                        0.0f, getHeight(), new Color(R, G, B, 0), true);
                Graphics2D g2d = (Graphics2D)g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());

            }
        }
    };
    panel.setOpaque(false);
    panel.setBackground(new Color(0,0,0,0));
    setContentPane(panel);
    setLayout(new GridBagLayout());
    add(Clock);


    new Thread(){
        public void run()
        {

            while(true)
            {
                Calendar cal = new GregorianCalendar();
                int hour = cal.get(Calendar.HOUR);
                int min = cal.get(Calendar.MINUTE);
                int sec = cal.get(Calendar.SECOND);


                String hourStr = "";
                String minStr = "";
                String secStr = "";
                if(hour < 10) {
                    hourStr = "0" + hour;
                }
                else {
                    hourStr = hour + "";
                }
                if(min < 10) {
                    minStr = "0" + min;
                }
                else {
                    minStr = min + "";
                }
                if(sec < 10) {
                    secStr = "0" + sec;
                }
                else {
                    secStr = sec + "";
                }
                time_spent = hourStr+":"+minStr+":"+secStr;

                //panel.repaint();

                Clock.setText(time_spent);
                Clock.setForeground(Color.BLACK);
                Clock.setFont(new Font("Serif", Font.BOLD, 70));
                Clock.setHorizontalAlignment(SwingConstants.CENTER);
                Clock.setVerticalAlignment(SwingConstants.CENTER);
                getContentPane().setBackground(Color.BLACK);

            }

        }
    }.start();


}

public static void main(String[] args) {
    // Determine what the GraphicsDevice can support.
    GraphicsEnvironment ge = 
        GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    boolean isPerPixelTranslucencySupported = 
        gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

    //If translucent windows aren't supported, exit.
    if (!isPerPixelTranslucencySupported) {
        System.out.println(
            "Per-pixel translucency is not supported");
            System.exit(0);
    }

    JFrame.setDefaultLookAndFeelDecorated(false);

    // Create the GUI on the event-dispatching thread
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            GradientTranslucentWindow gtw = new
                GradientTranslucentWindow();

            // Display the window.
            gtw.setVisible(true);
        }
    });
}


public void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    Clock = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    setUndecorated(true);
    setBounds(new java.awt.Rectangle(200, 200, 200, 200));
    setSize(300, 300);
    setVisible(true);



    Clock.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
    Clock.setForeground(new java.awt.Color(0, 0, 0, 0));
    Clock.setText("0:00:00");
    jPanel1.add(Clock);
    Clock.setBounds(0, 4, 280, 100);



    Clock.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseDragged(java.awt.event.MouseEvent evt) {
            jLabelMouseDragged(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    getAccessibleContext().setAccessibleName("myJframe");

    setBounds(0, 0, 299, 109);
}


private void jLabelMouseDragged(java.awt.event.MouseEvent evt) {
    int x = evt.getXOnScreen();
    int y = evt.getYOnScreen();
    this.setLocation(x, y);
}
// Variables declaration - do not modify                     
static javax.swing.JLabel Clock;
private javax.swing.JPanel jPanel1;
String time_spent = null;

// End of variables declaration  
}