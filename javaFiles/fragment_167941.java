import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class MultipleTabbedPane extends JFrame {

    public static final Dimension SIZE = new Dimension(300, 100);//size of tabbedpane
    private final JTabbedPane upper = new JTabbedPane();
    private final JTabbedPane lower = new JTabbedPane();
    private final JLayeredPane lp = new JLayeredPane();
    public static final int OFFSET = 21;//needed to shift the lower tabbedpane.

    public MultipleTabbedPane() {
        initComponents();
    }

    private void initComponents() {

        String tabName[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        //String tabName[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        //"11", "12", "13", "14", "15", "16", "17", "18", "19"};//more tabs!
        for (int i = 0; i < tabName.length; i++) {
            if (i % 2 == 0) {//even number
                createTabbedPane(upper, tabName[i], true);//upper holds even numbers
            } else {
                createTabbedPane(lower, tabName[i], false);//upper holds odd numbers
            }
        }

        lp.add(upper, 0, new Integer(1));
        lp.add(lower, 0, new Integer(2));
        getContentPane().add(lp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Upper and Lower TabbedPane!");
        pack();
        setSize(new Dimension(400, 200));
        setVisible(true);
    }

    private void createTabbedPane(JTabbedPane tabbedPane, String s, boolean isUpper) {
        JLabel label = new JLabel("Tab " + s, SwingConstants.CENTER);
        tabbedPane.addTab("Tab " + s, null, label);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isUpper) {//if upper 

                    if (upper.getSelectedIndex() == -1) {//upper not selected
                        //fixes a bug, select the lower tabbedpane and click near the 
                        //last tab (to the right) of the upper tabbedpane, you will 
                        //see that it will be unselected if the "return;" is not 
                        //added below.
                        return;
                    }
                    lower.setSelectedIndex(-1);//unselect the lower tabbedpane
                    lp.moveToFront(upper);//move it to the front
                } else {//if lower 
                    if (lower.getSelectedIndex() == -1) {
                        //same argument as above.
                        return;
                    }
                    upper.setSelectedIndex(-1);//unselect the upper tabbedpane
                    lp.moveToFront(lower);//move it to the front
                }
            }
        });

        if (isUpper) {//upper tabbedpane
            tabbedPane.setBounds(0, 0, SIZE.width, SIZE.height);
        } else {//lower tabbedpane
            tabbedPane.setSelectedIndex(-1);
            tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
            tabbedPane.setBounds(0, OFFSET, SIZE.width, SIZE.height);
        }
    }

    public static void main(String args[]) {
        new MultipleTabbedPane();
    }
}