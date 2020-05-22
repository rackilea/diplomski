import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class DebugReport2 extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 700;
    public static final String PART_1 = "part 1";
    public static final String PART_2 = "part 2";
    public static final String PART_3 = "part 3";
    private CardLayout cardLayout = new CardLayout();
    private Part1Panel part1Panel = new Part1Panel(this);
    private Part2Panel part2Panel = new Part2Panel(this);
    private Part3Panel part3Panel = new Part3Panel(this);

    public DebugReport2() {
        setLayout(cardLayout);
        System.out.println(Part1Panel.class.getName());
        add(part1Panel, PART_1);
        add(part2Panel, PART_2);
        add(part3Panel, PART_3);
    }

    // public method to allow other classes to swap views
    public void showCard(String key) {
        cardLayout.show(this, key);
    }

    public void part2Reset() {
        part2Panel.reset();
    }

    public void setPart3SelectedOptionText(String selectedItem) {
        part3Panel.setSelectedOptionText(selectedItem);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        DebugReport2 mainPanel = new DebugReport2();

        JFrame frame = new JFrame("Debug Report 2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

@SuppressWarnings("serial")
class BaseContinueAction extends AbstractAction {
    private String key;
    private DebugReport2 debugReport2;

    public BaseContinueAction(String name, DebugReport2 debugReport2, String key) {
        super(name);
        int mnemnoic = (int) name.charAt(0);
        putValue(MNEMONIC_KEY, mnemnoic); // first letter is mnemonic alt-key press.
        this.key = key;
        this.debugReport2 = debugReport2;
    }

    public String getKey() {
        return key;
    }

    public DebugReport2 getDebugReport2() {
        return debugReport2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        debugReport2.showCard(key);
    }
}

@SuppressWarnings("serial")
class Part1Panel extends JPanel {
    private DebugReport2 debugReport2;

    public Part1Panel(DebugReport2 debugReport2) {
        this.debugReport2 = debugReport2;
        setBorder(BorderFactory.createTitledBorder("Part 1 Panel")); // for debug purposes

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton(new ContinueAction("Continue", debugReport2, DebugReport2.PART_2)));

        setLayout(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private class ContinueAction extends BaseContinueAction {

        public ContinueAction(String name, DebugReport2 debugReport2, String key) {
            super(name, debugReport2, key);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            super.actionPerformed(e);
            getDebugReport2().part2Reset();
        }

    }
}

@SuppressWarnings("serial")
class Part2Panel extends JPanel {
    private static final String[] DEFAULT_DATA = {"0", "1", "2", "3", "4", "5", "6"};

    private DebugReport2 debugReport2;
    private ComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
    private JComboBox<String> skillsCombo = new JComboBox<>(comboModel);

    public Part2Panel(DebugReport2 debugReport2) {
        ((DefaultComboBoxModel<String>)comboModel).addElement("");
        for (String item : DEFAULT_DATA) {
            ((DefaultComboBoxModel<String>)comboModel).addElement("Selection " + item);
        }

        this.debugReport2 = debugReport2;
        setBorder(BorderFactory.createTitledBorder("Part 2 Panel")); // for debug purposes

        JPanel centerPanel = new JPanel(); // uses default FlowLayout
        centerPanel.add(skillsCombo);

        JPanel bottomPanel = new JPanel(); // again default FlowLayout
        bottomPanel.add(new JButton(new ContinueAction("Continue", debugReport2, DebugReport2.PART_3)));

        setLayout(new BorderLayout());
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);

    }

    // if you need outside classes to be able to change the combo box model
    // also resets selected index to -1
    public void setComboModel(ComboBoxModel<String> comboModel) {

        // reset combobox selection to -1, but remove listeners before doing so, and then
        // re-add them afterwards
        ItemListener[] itemListeners = skillsCombo.getItemListeners();
        for (ItemListener itemListener : itemListeners) {
            skillsCombo.removeItemListener(itemListener);
        }

        this.comboModel = comboModel;
        skillsCombo.setModel(comboModel);
        skillsCombo.setSelectedIndex(-1);

        for (ItemListener itemListener : itemListeners) {
            skillsCombo.addItemListener(itemListener);
        }
    }

    public void reset() {
        ComboBoxModel<String> model = skillsCombo.getModel();
        setComboModel(model);
    }

    private class ContinueAction extends BaseContinueAction {

        private String selectedItem = "";

        public ContinueAction(String name, DebugReport2 debugReport2, String key) {
            super(name, debugReport2, key);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            selectedItem = (String) skillsCombo.getSelectedItem();
            if (selectedItem == null || selectedItem.trim().isEmpty()) {
                Component parent = debugReport2;
                String title = "Option Not Selected";
                String message = "You must select an option before continuing";
                int type = JOptionPane.ERROR_MESSAGE;
                JOptionPane.showMessageDialog(parent, message, title, type);
            } else {
                // show the next view in the card layout
                super.actionPerformed(e);
                getDebugReport2().setPart3SelectedOptionText(selectedItem);
            }
        }

    }
}

@SuppressWarnings("serial")
class Part3Panel extends JPanel {
    private DebugReport2 debugReport2;
    private JTextField selectedOptionField = new JTextField(10);

    public Part3Panel(DebugReport2 debugReport2) {
        this.debugReport2 = debugReport2;
        setBorder(BorderFactory.createTitledBorder("Part 3 Panel")); // for debug purposes
        add(new JLabel("Selected Option:"));
        add(selectedOptionField);
        add(new JButton(new BaseContinueAction("Continue", debugReport2, DebugReport2.PART_1)));
    }

    public void setSelectedOptionText(String text) {
        selectedOptionField.setText(text);
    }

}