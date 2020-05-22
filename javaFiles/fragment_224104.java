import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Lab4Part2 {
//Attributes

    private JFrame frame;
    private String progress;

//Constructor
    public Lab4Part2() {
        //Create frame with specified grid layout
        frame = new JFrame();
        GridLayout grid = new GridLayout(0, 1);
        frame.setLayout(grid);
        JButton jbClick = new JButton("Let's start this show");
        frame.add(jbClick);

        //Add in JProgressBars and create Inner Class objects with them
        JProgressBar jpb1 = new JProgressBar();
        JProgressBar jpb2 = new JProgressBar();
        InnerProgress bar1 = new InnerProgress("Progress 1: ", jpb1);
        InnerProgress bar2 = new InnerProgress("Progress 2: ", jpb2);

        //Anonymous class for the button's action listener
        jbClick.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Thread t1 = new Thread(bar1);
                Thread t2 = new Thread(bar2);
                t1.start();
                t2.start();
            }
        });

        //Adds inner object to frame
        frame.add(bar1);
        frame.add(bar2);

        //Packing and stuff
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Inner class
    class InnerProgress extends JPanel implements Runnable {

        private JProgressBar jpb;

        //Constructor
        public InnerProgress(String pbar, JProgressBar jpBar) {
            jpBar.setMinimum(0);
            jpBar.setMaximum(80);
            jpBar.setStringPainted(true);
            progress = pbar;
            jpb = jpBar;
            JLabel label = new JLabel(pbar);
            add(label);
            add(jpBar);
        }

        //Thread action
        public void run() {
            System.out.println("We are running " + Thread.currentThread().getName());
            for (int i = 1; i <= 80; i++) {
                try {
                    Thread.currentThread().sleep((int)(Math.random() * 500));
                    updateProgress(i);
                } catch (InterruptedException ie) {
                    System.out.println(ie);
                }
            }
            System.out.println("Thread name: " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        }

    protected void updateProgress(int value) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InnerProgress.this.jpb.setValue(value);
            }
        });
    }
    }

    //Main
    public static void main(String[] args) {
        new Lab4Part2();
    }

}