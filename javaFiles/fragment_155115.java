import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CheckBoxTest {

    private JPanel panel;
    private int counter=0;

    public CheckBoxTest(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        JButton button = new JButton(" Add checkbox ");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                panel.add(new JCheckBox("CheckBox"+Integer.toString(counter++)));
                //now tell the view to show the new components added
                panel.revalidate();
                panel.repaint();
                //optional sizes the window again to show all the checkbox
                SwingUtilities.windowForComponent(panel).pack();
            }
        });
        panel.add(button);
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Checkbox example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLocationByPlatform(Boolean.TRUE);
        CheckBoxTest test = new CheckBoxTest();
        frame.add(test.panel);

        //sizes components
        frame.pack();
        frame.setVisible(Boolean.TRUE);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}