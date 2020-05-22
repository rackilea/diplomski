import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

public class Tab extends JFrame {

    private JTextArea messageTextArea;
    private JPanel optionPanel, messagePanel;
    private JTabbedPane plotTabPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {

                final Tab tab = new Tab();
                tab.setVisible(true);
                Timer t = new Timer(200, new ActionListener() {

                    int count = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tab.printRawMessage("testMessage" + count++);
                    }
                });
                t.start();
            }
        });
    }

    public Tab() {
        initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new GridLayout(1, 0));
        Box leftPanel = new Box(BoxLayout.Y_AXIS);
        leftPanel.add(getLeftTopPanel());
        leftPanel.add(getMessagePanel());
        mainPanel.add(leftPanel);
        mainPanel.add(getRightPanel());
        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    protected JPanel getLeftTopPanel() {
        optionPanel = new JPanel();
        optionPanel.setBorder(BorderFactory.createTitledBorder(null,
            "Configuration", TitledBorder.LEFT, TitledBorder.TOP,
            new Font("null", Font.BOLD, 12), Color.BLUE));
        JLabel label = new JLabel("Choose");
        label.setHorizontalAlignment(JLabel.RIGHT);
        optionPanel.add(label);
        optionPanel.add(new JSeparator(JSeparator.VERTICAL));
        optionPanel.add(new JComboBox(
            new String[]{"option1", "option2", "option3"}));
        optionPanel.add(new JLabel("Type"));
        optionPanel.add(new JTextField("3"));
        return optionPanel;
    }

    protected JTabbedPane getRightPanel() {
        plotTabPane = new JTabbedPane();
        plotTabPane.add("Tab1", new JPanel());
        plotTabPane.add("Tab2", new JPanel());
        return plotTabPane;
    }

    protected JPanel getMessagePanel() {
        messagePanel = new JPanel(new GridLayout());
        messagePanel.setBorder(BorderFactory.createTitledBorder(null,
            "Status Console", TitledBorder.LEFT, TitledBorder.TOP,
            new Font("null", Font.BOLD, 12), Color.BLUE));
        final JScrollPane sp = new JScrollPane(getMessageTextArea());
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        messagePanel.add(sp);
        return messagePanel;
    }

    protected JTextArea getMessageTextArea() {
        messageTextArea = new JTextArea("", 10, 19);
        messageTextArea.setEditable(false);
        messageTextArea.setFont(new Font(null, Font.PLAIN, 20));
        messageTextArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        DefaultCaret caret = (DefaultCaret) messageTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        return messageTextArea;
    }

    public void printRawMessage(String rawMessage) {
        messageTextArea.append(rawMessage + "\n");
    }
}