import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SimpleMain {

    protected static final Insets   DEFAULT_INSETS  = new Insets(0, 4, 4, 4);

    protected static JTextArea area;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // createAndShowMigGUI();
                createAndShowSwingGUI();
            }
        });
    }

    private static void createAndShowSwingGUI() {
        final JFrame frame = new JFrame("Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Frame */
        frame.setLayout(new BorderLayout());

        /* Outer Panel */
        JPanel outerPanel = new JPanel(new BorderLayout());

        outerPanel.add(new JTextField("inner north"), BorderLayout.NORTH);
        outerPanel.add(new JTextField("inner south"), BorderLayout.SOUTH);
        outerPanel.add(new JTextField("inner west"), BorderLayout.WEST);
        outerPanel.add(new JTextField("inner east"), BorderLayout.EAST);

        area = setTextArea();

        final JScrollPane scrollPane = new JScrollPane(area);

        /* Elements Container */
        final JPanel innerPanel = new JPanel(new GridBagLayout());

        /* Elements */
        int gridy = 0;

        // This component should use all available Y-space
        addComponent(innerPanel, scrollPane, 0, gridy++, 1, 1, 1.0D, 800.0D,
                DEFAULT_INSETS, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);

        // Remain as-is
        JRadioButton helloButton = new JRadioButton("Test hello");
        addComponent(innerPanel, helloButton, 0, gridy++, 1, 1, 1.0D, 1.0D,
                DEFAULT_INSETS, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        // Remain as-is
        JTextField textField1 = new JTextField("some text field...");
        addComponent(innerPanel, textField1, 0, gridy++, 1, 1, 1.0D, 1.0D,
                DEFAULT_INSETS, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        // This component should use all available Y-space
        JTextField textField2 = new JTextField("some text field PUSH...");
        addComponent(innerPanel, textField2, 0, gridy++, 1, 1, 1.0D, 800.0D,
                DEFAULT_INSETS, GridBagConstraints.LINE_START,
                GridBagConstraints.BOTH);

        /* Add Inner Panel To Outer Panel */
        outerPanel.add(new JScrollPane(innerPanel), BorderLayout.CENTER);

        /* Add outer elements */
        frame.getContentPane().add(new JTextField("outer north"),
                BorderLayout.NORTH);
        frame.getContentPane().add(new JTextField("outer south"),
                BorderLayout.SOUTH);
        frame.getContentPane().add(new JTextField("outer west"),
                BorderLayout.WEST);
        frame.getContentPane().add(new JTextField("outer east"),
                BorderLayout.EAST);
        frame.getContentPane().add(outerPanel, BorderLayout.CENTER);

        frame.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent event) {
                scrollPane.getViewport().remove(area);
                area = setTextArea();
                scrollPane.getViewport().add(area);
            }
        });

        frame.setSize(800, 600);
        frame.setLocation(40, 40);
        frame.setVisible(true);
    }

    private static JTextArea setTextArea() {
        /* Text Area */
        JTextArea area = new JTextArea();
        area.setText("aHJAskjdhuyawduyawd Askjdhuyawduyawd Askjdhuyawduyawd "
                + "AskjdhuyawduyawdHJAskjdhuyawduyawd Askjdhuyawduyawd "
                + "Askjdhuyawduyawd AskjdhuyawduyawdHJAskjdhuyawduyawd "
                + "Askjdhuyawduyawd Askjdhuyawduyawd "
                + "AskjdhuyawduyawdHJAskjdhuyawduyawd Askjdhuyawduyawd "
                + "Askjdhuyawduyawd AskjdhuyawduyawdHJAskjdhuyawduyawd "
                + "Askjdhuyawduyawd Askjdhuyawduyawd Askjdhuyawduyawd");

        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        return area;
    }

    private static void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight,
            double weightx, double weighty, Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, weightx, weighty, anchor, fill, insets,
                0, 0);
        container.add(component, gbc);
    }
}