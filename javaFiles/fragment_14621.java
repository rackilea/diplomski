import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class CustomerWindow extends JFrame {
//Attribute

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                CustomerWindow frame = new CustomerWindow();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private JTextField textTF;
    private JButton copyButton;
    private JLabel copyLabel;
    private Border panelEdge;

//Constructor
    public CustomerWindow() {
        this.setBounds(100, 100, 800, 600);
        panelEdge = BorderFactory.createEtchedBorder();

        JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
        mainPanel.add(createCustomerPanel(), BorderLayout.NORTH);
        mainPanel.add(createCustomerInfoPanel(), BorderLayout.EAST);
        mainPanel.add(createSearchPanel(), BorderLayout.WEST);

        add(mainPanel);
    }

//Operational Methods
    public JPanel createCustomerPanel() {
        JPanel customerPanel = new JPanel();

        JLabel customerL = new JLabel("Clients", SwingConstants.CENTER);
        customerL.setForeground(Color.blue);
        customerL.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 48));
        customerPanel.add(customerL);

        customerPanel.setBorder(panelEdge);

        return customerPanel;
    }

    public JPanel createCustomerInfoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(panelEdge);

        JLabel infoL = new JLabel("Clients", SwingConstants.CENTER);
        infoL.setForeground(Color.blue);
        infoL.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 48));
        infoPanel.add(infoL);

        //add a text field
        textTF = new JTextField(50);
        infoPanel.add(textTF);

        //add a button
        copyButton = new JButton("Copy Text");
//        copyButton.addActionListener(new ButtonListener());
        infoPanel.add(copyButton);

        copyLabel = new JLabel("-----------------");

        infoPanel.add(copyLabel);

        return infoPanel;
    }

    public JPanel createSearchPanel() {
        JPanel lowerPanel = new JPanel();
        JLabel label = new JLabel("Text Transferred from JList:");

        //the spot where the data shows up
        lowerPanel.add(label);
        return lowerPanel;

    }

}