package test;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultHighlighter;

public class TableExample {
    JFrame f;
    private JTextField textField; // make the textfield a field so u can grab its text whenever u need it (in our
                                    // case in renderer)
    private HashMap<String, Color> words = new HashMap<>();

    TableExample() {
        f = new JFrame();
        // I changed the data a bit for my tests, take care of that.
        String data[][] = { { "101", "lala", "670000" }, { "101", "lala", "670000" }, { "102", "Jai", "780000" },
                { "101", "Sachin", "700000" } };
        String column[] = { "ID", "NAME", "SALARY" };
        JTable jt = new JTable();
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt); // You were not adding the sp into your panel, take care that next time.

        DefaultTableModel dtm = new DefaultTableModel(data, column); // Create the model with our data.
        dtm.setColumnIdentifiers(column);
        jt.setModel(dtm);

        JPanel inputpanel = new JPanel();
        inputpanel.setLayout(new BoxLayout(inputpanel, BoxLayout.LINE_AXIS));

        textField = new JTextField();
        JButton button = new JButton("Highlight");

        button.addActionListener(e -> { // Button should only repaint the table (a.k.a read the renderer again).
            words.clear(); //Clear the map with the words
            String text = textField.getText(); // Grab the text.
            if (text.trim().length() > 0) {
                String[] splitPattern = text.split(","); //Split the words
                for (String s : splitPattern) {
                    words.put(s, getARandomColor()); //Put each word with a RANDOM color.
                }
            }
            jt.repaint();// Changing the table's renderer is bad on every button click, and no needed.
        });

        inputpanel.add(textField);
        inputpanel.add(button);
        jt.setDefaultRenderer(Object.class, new CellHighlightRenderer()); // Add the renderer only 1 time.

        // I add sp here, not the table (if you want your table to actually have a
        // scrollpane)
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputpanel, sp);

        f.add(splitPane);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Hopefully you didnt forget this.
        f.setSize(300, 400);
        f.pack(); // Use pack() to the frame between set it visible.
        // f.setVisible(true); //setVisible to constructor is bad idea. I suggest you to
        // avoid that, and show your frame after its initiation.
    }

    class CellHighlightRenderer extends JTextField implements TableCellRenderer {
        public DefaultHighlighter high = new DefaultHighlighter();
        public DefaultHighlighter.DefaultHighlightPainter highlight_painter = new DefaultHighlighter.DefaultHighlightPainter(
                Color.YELLOW);

        public CellHighlightRenderer() {
            setBorder(BorderFactory.createEmptyBorder());
            setHighlighter(high);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {

            setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());

            setFont(table.getFont());
            setValue(value);
            int pos = 0;

            if (words.size() > 0) {
                for (String word : words.keySet()) {
                    while ((pos = value.toString().indexOf(word, pos)) >= 0) {
                        try {
                            highlight_painter = new DefaultHighlighter.DefaultHighlightPainter(words.get(word));
                            // high.addHighlight(first, last, highlight_painter);
                            high.addHighlight(pos, pos + word.length(), highlight_painter);
                            pos += word.length();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return this;
        }

        protected void setValue(Object value) {
            setText((value == null) ? "" : value.toString());
        }
    }

    private Color getARandomColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

    public static void main(String[] args) {
        /* *******THIS IS VERY IMPORTANT******* */
        /* All swing applications should run in their own thread, named EDT */
        SwingUtilities.invokeLater(() -> {
            TableExample te = new TableExample();
            te.f.setVisible(true); // Here, make it visisble
        });

    }
}