import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DelayedLabels extends JPanel {

    static JFrame frame;
    Timer timer;   //timer to be used for dealy
    JLabel card_1;  //Defining the JLabels
    JLabel card_2;
    JLabel card_3;
    JLabel[] labelsArray;
    ActionListener listener;

    public DelayedLabels() {
        listener = new ActionListener() {

            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                Component c = DelayedLabels.this.getTopLevelAncestor();
                DelayedLabels.this.add(labelsArray[i++]);
                c.validate();
                c.repaint();
                if (i==labelsArray.length) {
                    timer.stop();
                }
            }
        };
        this.setLayout(new GridLayout(0, 1, 20, 20));

        card_1 = new JLabel("Label 1");
        card_2 = new JLabel("Label 2");
        card_3 = new JLabel("Label 3");

        labelsArray = new JLabel[3]; //create the array

        createLabelsArray(); //add the Labels Objects to labelsArray
        timer = new Timer(1000,listener);
        timer.start();
    }

    private void createLabelsArray() {
        labelsArray[0] = card_1;
        labelsArray[1] = card_2;
        labelsArray[2] = card_3;
    }

    private static void createAndShowGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DelayedLabels demo = new DelayedLabels();
        demo.setOpaque(true);
        frame.add(demo, BorderLayout.PAGE_START);
        frame.pack();
        frame.setSize(200, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}