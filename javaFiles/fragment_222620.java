import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;

/** @see http://stackoverflow.com/a/34497773/230513 */
public class Test extends JPanel {

    private final String[] values = {"Value1", "Value2", "Value3", "Value4"};
    private final JList myList = new JList(values);
    private final JLabel myLabel = new JLabel();

    public Test() {
        myList.setSelectedIndex(values.length - 1);
        myLabel.setText(getSelectionIndex());
        this.add(myList);
        this.add(myLabel);
        this.add(new JButton(new AbstractAction("Show Selected Index") {

            @Override
            public void actionPerformed(ActionEvent e) {
                myLabel.setText(getSelectionIndex());
            }
        }));
    }

    private String getSelectionIndex() {
        return String.valueOf(myList.getSelectedIndex());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.add(new Test());
            f.pack();
            f.setLocationByPlatform(true);
            f.setVisible(true);
        });
    }
}