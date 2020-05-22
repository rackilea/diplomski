import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Suggestions {

    private JFrame frame;
    private JTextPane textPane;
    private JComboBox suggestionComboBox;
    private SuggestionComboBoxListener selectionListener;

    public Suggestions() {
        frame = new JFrame("Snort Ruleset IDE");

        textPane = new JTextPane();
        textPane.setCaretPosition(0);
        textPane.setMargin(new Insets(5, 5, 5, 5));
        textPane.addCaretListener(new SuggestionCaretListener());
        JScrollPane textEntryScrollPane = new JScrollPane(textPane);
        textEntryScrollPane.setPreferredSize(new Dimension(300, 400));

        selectionListener = new SuggestionComboBoxListener(frame);
        suggestionComboBox = new JComboBox();
        suggestionComboBox.setEditable(false);
        suggestionComboBox.setPreferredSize(new Dimension(25, 25));
        suggestionComboBox.addItemListener(selectionListener);

        JPanel suggestionPanel = new JPanel(new BorderLayout());
        suggestionPanel.add(suggestionComboBox, BorderLayout.PAGE_END);

        frame.getContentPane().add(textEntryScrollPane, BorderLayout.NORTH);
        frame.getContentPane().add(suggestionPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private final class SuggestionCaretListener implements CaretListener {
        @Override
        public void caretUpdate(CaretEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    generateSuggestions();
                }
            });
        }
    }

    public static final class SuggestionComboBoxListener implements ItemListener {
        Component parent;
        public SuggestionComboBoxListener(Component parent) {
            this.parent = parent;
        }
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                 JComboBox cb = (JComboBox) e.getSource();
                 String selection = (String) cb.getSelectedItem();
                 JOptionPane.showMessageDialog(parent, "The selected item is: " + selection, "Information",
                 JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    void generateSuggestions() {
        suggestionComboBox.removeItemListener(selectionListener);
        suggestionComboBox.removeAllItems();
        for (int i = 0; i < 5; i++) {
            suggestionComboBox.addItem(Integer.toString(i));
        }
        suggestionComboBox.setEnabled(true);
        suggestionComboBox.addItemListener(selectionListener);
    }

    public static void main(String[] args) {
        new Suggestions();
    }
}