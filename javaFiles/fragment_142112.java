import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;


public class ComboBoxHoverOver {

    private JComboBox combo = new JComboBox();

    public ComboBoxHoverOver() {
        combo.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXX");
        combo.setRenderer(new ComboToolTipRenderer(combo));
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(combo.getSelectedItem().toString());
            }
        });
        combo.addItem("");
        combo.addItem("Long text 4");
        combo.addItem("Long text 3");
        combo.addItem("Long text 2");
        combo.addItem("Long text 1");
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(combo);
        f.pack();
        f.setVisible(true);
    }

    private class ComboToolTipRenderer extends BasicComboBoxRenderer {

        private static final long serialVersionUID = 1L;
        private JComboBox combo;
        private JList comboList;

        ComboToolTipRenderer(JComboBox combo) {
            this.combo = combo;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (comboList == null) {
                comboList = list;
                KeyAdapter listener = new KeyAdapter() {

                    @Override
                    public void keyReleased(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                            int x = 5;
                            int y = comboList.indexToLocation(comboList.getSelectedIndex()).y;
                            System.out.println(comboList.getSelectedIndex());
                        }
                    }
                };
                combo.addKeyListener(listener);
                combo.getEditor().getEditorComponent().addKeyListener(listener);
            }
            if (isSelected) {
                System.out.println(value.toString());
            }
            return this;
        }
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ComboBoxHoverOver comboBoxHoverOver = new ComboBoxHoverOver();
            }
        });
    }
}