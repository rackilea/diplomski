package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class ImageWindow extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private Image img;

    /**
     * Launch the application.
     */

    /*
     * private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt)
     * {//GEN-FIRST:event_jButton8ActionPerformed try { CaptureFrame capone =
     * new GetCapture(); this.initFingerprint(this.openFile()); } catch
     * (IOException e1) { e1.printStackTrace(); } catch (InterruptedException
     * e1) { e1.printStackTrace(); }
     * 
     * }
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    ImageWindow window = new ImageWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ImageWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 378);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        this.setForeground(Color.PINK);
        this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.setBounds(27, 11, 268, 303);
        frame.getContentPane().add(this);

        JButton btnNewButton = new JButton("capture");
        btnNewButton.setToolTipText("");
        btnNewButton.setSelectedIcon(new ImageIcon("D:\\biometric1\\TestJniPrj\\single.jpg"));
        btnNewButton.setBounds(318, 146, 89, 23);
        frame.getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                img = Toolkit.getDefaultToolkit().createImage(ImageWindow.this.getClass().getResource("test.png"));
                ImageWindow.this.repaint();
            }
        });
    }

    public void paintComponent(Graphics g) {
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }
}