import java.awt.Container;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;


public class Expander extends JFrame {

    private final JTextArea area;
    private int hSize = 1;
    private int vSize = 1;

    public Expander() {
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

        cp.add(Box.createHorizontalGlue());
        area = new JTextArea(vSize, hSize);
        cp.add(area);
        cp.add(Box.createHorizontalGlue());

        area.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                adjust();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                adjust();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                adjust();
            }
        });

        pack();
    }

    private void adjust() {
        int maxColumns = getMaxColumns();
        if ((area.getLineCount() != vSize) || (maxColumns != hSize)) {
            hSize = maxColumns;
            vSize = area.getLineCount();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    area.setColumns(hSize);
                    area.setRows(vSize);
                    Expander.this.doLayout();
                    Expander.this.pack();
                }
            });
        }
    }

    private int getMaxColumns() {
        int startOffset = 0;
        int maxColumns = 0;
        for (int i = 0; i < area.getLineCount(); i++) {
            try {
                int endOffset = area.getLineEndOffset(i);
                int lineSize = endOffset - startOffset;
                if (lineSize > maxColumns) {
                    maxColumns = lineSize;
                }
                startOffset = endOffset;
            } catch (BadLocationException ble) {
            }
        }

        return maxColumns;
    }

    public static void main(String[] args) {

        Expander e = new Expander();
        e.setLocationRelativeTo(null);
        e.setVisible(true);
    }
}