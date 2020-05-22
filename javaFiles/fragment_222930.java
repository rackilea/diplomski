import java.awt.*;
import javax.swing.*;

public class TestHighLightRow {

    public void makeUI() {
        Object[] data = {"One", "Two", "Three"};
        JComboBox comboBox = new JComboBox(data);
        comboBox.setPreferredSize(comboBox.getPreferredSize());
        comboBox.setRenderer(new HighLightRowRenderer(comboBox.getRenderer()));
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(comboBox);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestHighLightRow().makeUI();
            }
        });
    }

    public class HighLightRowRenderer implements ListCellRenderer {

        private final ListCellRenderer delegate;
        private int height = -1;

        public HighLightRowRenderer(ListCellRenderer delegate) {
            this.delegate = delegate;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = delegate.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Dimension size = component.getPreferredSize();
            if (index == 0) {
                component.setBackground(Color.red);
                if (component instanceof JLabel) {
                    ((JLabel) component).setHorizontalTextPosition(JLabel.CENTER);
                }
            }
            return component;
        }
    }
}