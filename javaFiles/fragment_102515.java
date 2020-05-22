import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Test{

//public static final Test application = new Test();
private JFrame jFrame = null;
private JPanel jContentPane = null, buttonsPanel = null, cardPanel = null, manualPanel = null, uploadPanel = null,
        defaultPanel = null;
private JPanel[] mainPanel = new JPanel[3];
private JButton manualButton = null, uploadButton = null, manualAssignButton = null;
private JTextField manualEntryField = null;
private JLabel manualLabel = null;

final static String DEFAULTPANEL = "Default";
final static String MANUALPANEL = "Manual";
final static String UPLOADPANEL = "Upload";

Test() {
    mainPanel[0] = getDefaultPanel();
    mainPanel[1] = getManualPanel();
    mainPanel[2] = getUploadPanel();
}

/**
 * Main method
 * @param args
 */
public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            new Test().getJFrame().setVisible(true);
        }
    });
}

/**
 * Get the main application frame
 * @return JFrame
 */
private JFrame getJFrame() {
    if (jFrame == null) {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.setResizable(false);
        // Add the main content pane
        jFrame.setContentPane(getJContentPanel());
        jFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                closeApplication();
            }
        });
    }
    jFrame.pack();
    jFrame.setLocationRelativeTo(null);
    return jFrame;
}

/**
 * Get main content
 * @return JPanel
 */
private JPanel getJContentPanel(){
    if (jContentPane == null) {
        jContentPane = new JPanel();
        jContentPane.setPreferredSize(new Dimension(500, 200));
        jContentPane.setLayout(new BorderLayout());
        jContentPane.add(getButtonsPanel(), BorderLayout.NORTH);
        jContentPane.add(getCardPanel(), BorderLayout.CENTER);
    }
    return jContentPane;
}

private JPanel getButtonsPanel() {
    if(buttonsPanel == null){
        buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(500, 50));
        buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.gray));

        manualButton = new JButton("Enter manually");
        manualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cardPanel.getLayout());
                cl.show(cardPanel, MANUALPANEL);
            }
        });

        uploadButton = new JButton("Upload file");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)(cardPanel.getLayout());
                cl.show(cardPanel, UPLOADPANEL);
            }
        });

        buttonsPanel.add(manualButton);
        buttonsPanel.add(uploadButton);
    }
    return buttonsPanel;
}

private JPanel getCardPanel() {
    if(cardPanel == null){
        cardPanel = new JPanel(new CardLayout());
        cardPanel.setPreferredSize(new Dimension(500, 200));
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        cardPanel.add(mainPanel[0], DEFAULTPANEL);
        cardPanel.add(mainPanel[1], MANUALPANEL);
        cardPanel.add(mainPanel[2], UPLOADPANEL);
    }
    return cardPanel;
}

private JPanel getDefaultPanel() {
    if(defaultPanel == null){
        defaultPanel = new JPanel();
    }
    return defaultPanel;
}

private JPanel getManualPanel() {
    if(manualPanel == null){
        manualPanel = new JPanel();
        manualPanel.setLayout(new FlowLayout());

        manualEntryField = new JTextField(10);
        System.out.println("creating text field");
        manualEntryField.setText("Enter code");

        manualAssignButton = new JButton("Assign");
        manualAssignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             // Here is the exception
            System.out.println(manualEntryField);
            System.out.println(manualEntryField.getText());
            System.out.println(manualEntryField.getText().trim());
            }
        });

        manualLabel = new JLabel("Please enter a code and press assign");

        manualPanel.add(manualEntryField);
        manualPanel.add(manualAssignButton);
        manualPanel.add(manualLabel);

    }
    return manualPanel;
}

private JPanel getUploadPanel() {
    if(uploadPanel == null){
        uploadPanel = new JPanel();
    }
    return uploadPanel;
}

private void closeApplication() {
    System.exit(0);
}
}