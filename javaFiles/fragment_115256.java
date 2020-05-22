import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ColorfulButtons extends JFrame {

    private JLabel[] labels = new JLabel[5];

    // start the application, this starts the original thread
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ColorfulButtons frame = new ColorfulButtons();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ColorfulButtons() {
        // create your gui
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 0, 0, 0));

        for (int i = 0; i < 5; i++) {
            JLabel lbl = new JLabel("TEXT");
            add(lbl);
            labels[i] = lbl;
        }

        // start the color changing thread
        new Thread(new Runnable() {

            public void run() {
                doTheThing();
            }
            // give it a name for debugging
        }, "DoTheThingThread").start();
    }

    private void doTheThing() {
        int index = 0;
        while (true) {
            // put label in final variable so I can use it inside anonymous classes
            final JLabel lbl = labels[index];

            // make label yellow on Event Dispatch Thread
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    lbl.setForeground(Color.YELLOW);
                }
            });

            // pause to give the gui time to redraw and process events 
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // make label red on Event Dispatch Thread
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    lbl.setForeground(Color.RED);
                }
            });

            // increment or reset index
            if (index < 5 - 1)
                index++;
            else
                index = 0;
        }
    }
}