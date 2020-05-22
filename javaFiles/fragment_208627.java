import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/** @see http://stackoverflow.com/questions/7378821 */
public class TrashTest {

    private static final String MASK = "########";
    private static final String DEFAULT = "01234567";
    private static final String BOGUS = "0123456";
    private JFormattedTextField jtf1 = createField();
    private JFormattedTextField jtf2 = createField();
    private JFormattedTextField jtf3 = createField();
    private JFormattedTextField jtf4 = createField();
    private JButton reset = new JButton("Reset to Default");
    private JComboBox combo = new JComboBox();
    private JFrame frame = new JFrame("Text Test");

    public TrashTest() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(150, 150);
        frame.setLayout(new GridLayout(0, 1));
        frame.add(reset);
        frame.add(jtf1);
        frame.add(jtf2);
        frame.add(jtf3);
        frame.add(jtf4);
        frame.add(combo);
        this.initFields();
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                initFields();
            }
        });
        for (Edit e : Edit.values()) {
            combo.addItem(e);
        }
        combo.setSelectedIndex(jtf1.getFocusLostBehavior());
        combo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Edit current = (Edit) combo.getSelectedItem();
                jtf1.setFocusLostBehavior(current.value);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    private void initFields() {
        jtf1.setText(BOGUS);
        jtf2.setText(DEFAULT);
        jtf3.setText(DEFAULT);
        jtf4.setText(DEFAULT);
    }

    protected JFormattedTextField createField() {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(MASK);
        } catch (java.text.ParseException e) {
            e.printStackTrace(System.out);
        }
        JFormattedTextField jtf = new JFormattedTextField(formatter);
        return jtf;
    }

    enum Edit {

        COMMIT(JFormattedTextField.COMMIT),
        COMMIT_OR_REVERT(JFormattedTextField.COMMIT_OR_REVERT),
        REVERT(JFormattedTextField.REVERT),
        PERSIST(JFormattedTextField.PERSIST);
        private int value;

        private Edit(int n) {
            this.value = n;
        }

        public static Edit getEnum(int n) {
            for (Edit e : Edit.values()) {
                if (e.value == n) {
                    return e;
                }
            }
            return Edit.COMMIT_OR_REVERT;
        }
    }

    public static void main(String[] args) {
        TrashTest textTest = new TrashTest();
    }
}