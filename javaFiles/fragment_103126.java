import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class SimpleCityGui extends JPanel {
    private SimpleCity city = new SimpleCity();
    private SimpleHumanPanel humanPanel = new SimpleHumanPanel();

    public SimpleCityGui() {
        humanPanel.setFocusable(false);
        humanPanel.setBorder(BorderFactory.createTitledBorder("Current Human"));

        JPanel btnPanel = new JPanel();
        btnPanel.add(new JButton(new AddHumanAction("Add")));
        btnPanel.add(new JButton(new NextAction("Next")));
        btnPanel.add(new JButton(new PreviousAction("Previous")));

        setLayout(new BorderLayout());
        add(humanPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.PAGE_END);
    }

    private class AddHumanAction extends AbstractAction {
        SimpleHumanPanel innerHumanPanel = new SimpleHumanPanel();

        public AddHumanAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            innerHumanPanel.clear();
            Component parentComponent = SimpleCityGui.this;
            SimpleHumanPanel message = innerHumanPanel;
            String title = "Create a Human";
            int optionType = JOptionPane.OK_CANCEL_OPTION;
            int messageType = JOptionPane.PLAIN_MESSAGE;
            int selection = JOptionPane.showConfirmDialog(parentComponent,
                    message, title, optionType, messageType);

            if (selection == JOptionPane.OK_OPTION) {
                city.addHuman(innerHumanPanel.createHuman());
                humanPanel.setHuman(city.getCurrentHuman());
            }
        }
    }

    private class NextAction extends AbstractAction {

        public NextAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleHuman nextHuman = city.next();
            if (nextHuman != null) {
                humanPanel.setHuman(nextHuman);
            }
        }
    }

    private class PreviousAction extends AbstractAction {

        public PreviousAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleHuman previousHuman = city.previous();
            if (previousHuman != null) {
                humanPanel.setHuman(previousHuman);
            }
        }
    }

    private static void createAndShowGui() {
        SimpleCityGui mainPanel = new SimpleCityGui();

        JFrame frame = new JFrame("SimpleCityGui");
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
class SimpleHumanPanel extends JPanel {
    private static final int COLS = 10;
    private static final Insets INSETS = new Insets(5, 5, 5, 5);
    private JTextField firstNameField = new JTextField(COLS);
    private JTextField lastNameField = new JTextField(COLS);
    private JTextComponent[] textComponents = { firstNameField, lastNameField };
    private SimpleHuman human;

    public SimpleHumanPanel() {
        setLayout(new GridBagLayout());
        add(new JLabel("First Name:"), createGbc(0, 0));
        add(firstNameField, createGbc(1, 0));
        add(new JLabel("Last Name:"), createGbc(0, 1));
        add(lastNameField, createGbc(1, 1));
    }

    @Override
    public void setFocusable(boolean focusable) {
        super.setFocusable(focusable);
        for (JTextComponent jTextComponent : textComponents) {
            jTextComponent.setFocusable(focusable);
        }
    }

    public void setHuman(SimpleHuman human) {
        this.human = human;
        firstNameField.setText(human.getFirstName());
        lastNameField.setText(human.getLastName());
    }

    public SimpleHuman getHuman() {
        return human;
    }

    public void clear() {
        this.human = null;
        for (JTextComponent jTextComponent : textComponents) {
            jTextComponent.setText("");
        }
    }

    public SimpleHuman createHuman() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        human = new SimpleHuman(firstName, lastName);
        return human;
    }

    private static GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = INSETS;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }
}

class SimpleCity {
    private List<SimpleHuman> humanList = new ArrayList<>();
    private int humanListIndex = -1; // start with a nonsense value

    public void addHuman(SimpleHuman h) {
        humanList.add(h);
        if (humanListIndex == -1) {
            humanListIndex = 0;
        }
    }

    public SimpleHuman getHuman(int index) {
        return humanList.get(index);
    }

    public SimpleHuman getCurrentHuman() {
        if (humanListIndex == -1) {
            return null;
        }
        return humanList.get(humanListIndex);

    }

    public SimpleHuman next() {
        if (humanListIndex == -1) {
            return null;
        }

        humanListIndex++;
        humanListIndex %= humanList.size(); // set back to 0 if == size
        return humanList.get(humanListIndex);
    }

    public SimpleHuman previous() {
        if (humanListIndex == -1) {
            return null;
        }

        humanListIndex--;
        humanListIndex += humanList.size();
        humanListIndex %= humanList.size();
        return humanList.get(humanListIndex);
    }
}

class SimpleHuman {
    private String firstName;
    private String lastName;

    public SimpleHuman(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result
                + ((lastName == null) ? 0 : lastName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpleHuman other = (SimpleHuman) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SimpleHuman [firstName=" + firstName + ", lastName=" + lastName
                + "]";
    }

}