import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
public class ClearGrid extends JPanel {
    private static final int ROWS = 9;
    private static final int COLS = ROWS;
    private static final int GAP = 2;
    private static final Font FONT = new Font(Font.SANS_SERIF, Font.BOLD, 32);
    private static final int FIELD_COLS = 2;
    List<JTextComponent> textComponentList = new ArrayList<>();

    public ClearGrid() {
        JPanel gridPanel = new JPanel(new GridLayout(ROWS, COLS, GAP, GAP));
        gridPanel.setBackground(Color.BLACK);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JTextField textField = new JTextField(FIELD_COLS);
                textField.setFont(FONT);
                textField.setHorizontalAlignment(JTextField.CENTER);
                textComponentList.add(textField);
                gridPanel.add(textField);
            }
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new ClearAllAction("Clear All", KeyEvent.VK_C)));

        setLayout(new BorderLayout());
        add(gridPanel);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    private class ClearAllAction extends AbstractAction {
        public ClearAllAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textComponentList.stream().forEach(tc -> tc.setText(""));
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("ClearGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ClearGrid());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}