import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class MultTextAreasMain extends JPanel {
    private static final int DIALOG_COUNT = 4; //  how many dialogs?

    // Single Document shared by all JTextAreas -- thus they share text
    private PlainDocument document = new PlainDocument();
    private List<JTextArea> textAreas = new ArrayList<>(); // list of all text areas
    private MultTextAreaPanel panel1 = new MultTextAreaPanel(this);

    public MultTextAreasMain() {
        textAreas.add(panel1.getTextArea());
        setLayout(new BorderLayout());
        add(panel1);
    }

    public PlainDocument getDocument() {
        return document;
    }

    // public method to allow addition of text areas to the array list
    public void addTextArea(JTextArea textArea) {
        textAreas.add(textArea);
    }

    // sets the background color all text areas held by the array list
    public void setTextAreaBackground(Color value) {
        for (JTextArea jTextArea : textAreas) {
            jTextArea.setBackground(value);
        }
    }

    private static void createAndShowGui() {
        MultTextAreasMain main = new MultTextAreasMain();

        JFrame frame = new JFrame("MultTextAreas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(main);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        for (int i = 0; i < DIALOG_COUNT; i++) {
            MultTextAreaPanel mtaPanel = new MultTextAreaPanel(main);
            main.addTextArea(mtaPanel.getTextArea());
            String title = "Dialog " + (i + 1);
            JDialog dialog = new JDialog(frame, title, ModalityType.MODELESS);
            dialog.add(mtaPanel);
            dialog.pack();
            dialog.setLocationByPlatform(true);
            dialog.setVisible(true);
        }
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
class MultTextAreaPanel extends JPanel {
    public static final int GRAY = 150;
    public static final Color[] COLORS = { 
            new Color(255, GRAY, GRAY), 
            new Color(GRAY, 255, GRAY),
            new Color(GRAY, GRAY, 255), 
            new Color(255, 255, GRAY), 
            new Color(255, GRAY, 255),
            new Color(GRAY, 255, 255) };
    private JTextArea textArea = new JTextArea(10, 30);
    private MultTextAreasMain main;
    JComboBox<Color> colorsCombo = new JComboBox<>(COLORS);

    public MultTextAreaPanel(MultTextAreasMain main) {
        this.main = main;
        PlainDocument doc = main.getDocument();
        textArea.setDocument(doc);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        colorsCombo.setRenderer(new ColorListCellRenderer());
        colorsCombo.addActionListener(new ColorsListener());

        JPanel comboPanel = new JPanel();
        comboPanel.add(colorsCombo);

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea));
        add(comboPanel, BorderLayout.PAGE_END);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    // combo box listener that gets the selected color from the combo box
    // and then calls the main class's method to change the background
    // color of all the JTextAreas held by the ArrayList
    private class ColorsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color value = (Color) colorsCombo.getSelectedItem();
            if (value != null) {
                main.setTextAreaBackground(value);
            }
        }
    }

    // a renderer for the JComboBox. This displays the RGB constants for colors along with 
    // showing each item's background color. A selected item is darker. 
    private class ColorListCellRenderer extends DefaultListCellRenderer {
        private final int darker = 20;

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                boolean cellHasFocus) {
            DefaultListCellRenderer renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value,
                    index, isSelected, cellHasFocus);
            renderer.setOpaque(true);
            Color color = (Color) value;
            String text = String.format("Color [%d, %d, %d]", color.getRed(), color.getGreen(), color.getBlue());
            renderer.setText(text);
            if (isSelected) {
                int r = color.getRed() == 255 ? 255 : darker;
                int g = color.getGreen() == 255 ? 255 : darker;
                int b = color.getBlue() == 255 ? 255 : darker;
                color = new Color(r, g, b);
            }
            renderer.setBackground(color);
            return renderer;
        }
    }
}