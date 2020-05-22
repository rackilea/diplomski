import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;    
import javax.swing.*;

public class SelectButton extends JPanel {
    private static final String[] TEXTS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JComboBox<String> comboBox = new JComboBox<>(TEXTS);

    public SelectButton() {
        JPanel rBtnPanel = new JPanel(new GridLayout(1, 0));
        for (String text : TEXTS) {
            JRadioButton radioButton = new JRadioButton(text);
            radioButton.setActionCommand(text);
            rBtnPanel.add(radioButton);
            buttonGroup.add(radioButton);
        }

        comboBox.setSelectedIndex(-1);
        comboBox.addActionListener(new ComboListener());
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(comboBox);

        setLayout(new BorderLayout());
        add(rBtnPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private class ComboListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = comboBox.getSelectedItem().toString();
            Enumeration<AbstractButton> elements = buttonGroup.getElements();
            while (elements.hasMoreElements()) {
                AbstractButton btn = elements.nextElement();
                if (btn.getActionCommand().equals(command)) {
                    buttonGroup.setSelected(btn.getModel(), true);
                }
            }

        }
    }

    private static void createAndShowGui() {
        SelectButton mainPanel = new SelectButton();

        JFrame frame = new JFrame("Main");
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