import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ListTryout {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
//                UIManager.put("List.focusCellHighlightBorder", new StrokeBorder(new BasicStroke(2f)));
                final JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JList<String> l = new JList<String>(new String[] {"one", "two", "three"});
                l.setCellRenderer(new MyRenderer());
                f.add(new JScrollPane(l));
                f.pack();
                f.setVisible(true);
            }
        });
    }

    private static class MyRenderer extends DefaultListCellRenderer {
        /**
         * {@inheritDoc}
         */
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component result = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (!isSelected && cellHasFocus) { // custom highlight of focused but not-selected cell
                result.setBackground(Color.LIGHT_GRAY);
                ((JComponent) result).setBorder(null);
            }
            return result;
        }
    }
}