import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Main class for starting the application.
 */
public class MainProgram {
    public static void main(String[] args) {
        new TopFrame();
    }
}

/**
 * The main, top-most frame in demo app including combobox panel, card panel, and a common action button.
 */
class TopFrame extends JFrame implements ItemListener {

    CardPanel pnlCard = new CardPanel();
    JButton btnWithCommonAction = new JButton("Common action");

    public TopFrame() {
        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = {"A", "B"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        //
        // !
        getContentPane().add(comboBoxPane, BorderLayout.PAGE_START);
        getContentPane().add(pnlCard, BorderLayout.CENTER);
        getContentPane().add(btnWithCommonAction, BorderLayout.PAGE_END);
        //
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (pnlCard.getLayout());
        cl.show(pnlCard, (String) evt.getItem());
    }
}

class CardPanel extends JPanel {
    JPanel cardA = new PanelWithSomeFunc("Functionality A");
    JPanel cardB = new PanelWithSomeFunc("Functionality B");
    public CardPanel() {
        setLayout(new CardLayout());
        add(cardA, "A");
        add(cardB, "B");
    }
}

/**
 * Simulates a panel with some functionality.
 * For demo purposes it contains a label and a sample button only.
 */
class PanelWithSomeFunc extends JPanel {

    private JLabel lblTitle;
    private JButton btnAction;

    public PanelWithSomeFunc(String functionalityName) {
        lblTitle = new JLabel(functionalityName);
        btnAction = new JButton(functionalityName);
        organizeLayout();
        final String textToDisplay = functionalityName;
        btnAction.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(new JFrame(), textToDisplay);
                    }
                }
        );
    }

    private void organizeLayout() {
        setLayout(new BorderLayout());
        add(lblTitle, BorderLayout.CENTER);
        add(btnAction, BorderLayout.PAGE_END);
    }
}

class CommonAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(new JFrame(), "This action is available regardless of which panel is displayed");
    }
}