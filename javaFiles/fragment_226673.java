import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class TestListCellRenderer {

    public static void main(String[] args) {
        new TestListCellRenderer();
    }

    public TestListCellRenderer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultListModel model = new DefaultListModel();
                model.addElement(new Item("A", "a", "aa"));
                model.addElement(new Item("B", "b", "bb"));
                model.addElement(new Item("C", "c", "cc"));
                model.addElement(new Item("D", "d", "dd"));

                JList list = new JList(model);
                list.setCellRenderer(new ItemCellRenderer());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(list));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class Item {
        private String name;
        private String col1;
        private String col2;

        public Item(String name, String col1, String col2) {
            this.name = name;
            this.col1 = col1;
            this.col2 = col2;
        }

        public String getCol1() {
            return col1;
        }

        public String getCol2() {
            return col2;
        }

        public String getName() {
            return name;
        }

    }

    public static class ItemCellRenderer extends JPanel implements ListCellRenderer<Item>{

        private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    protected static Border noFocusBorder = DEFAULT_NO_FOCUS_BORDER;

        JLabel name = new JLabel(" ");
        JLabel col1 = new JLabel(" ");
        JLabel col2 = new JLabel(" ");

        public ItemCellRenderer() {
            setLayout(new BorderLayout());
            add(name, BorderLayout.WEST);
            add(col1, BorderLayout.CENTER);
            add(col2, BorderLayout.EAST);
        }

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(100, 20);
        }

        @Override
        public Dimension getPreferredSize() {
            return getMinimumSize();
        }


    protected Border getNoFocusBorder() {
        Border border = UIManager.getBorder("List.cellNoFocusBorder");
        if (System.getSecurityManager() != null) {
            if (border != null) return border;
            return SAFE_NO_FOCUS_BORDER;
        } else {
            if (border != null &&
                    (noFocusBorder == null ||
                    noFocusBorder == DEFAULT_NO_FOCUS_BORDER)) {
                return border;
            }
            return noFocusBorder;
        }
    }

        @Override
        public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected, boolean cellHasFocus) {
            setComponentOrientation(list.getComponentOrientation());

            Color bg = null;
            Color fg = null;

            JList.DropLocation dropLocation = list.getDropLocation();
            if (dropLocation != null
                            && !dropLocation.isInsert()
                            && dropLocation.getIndex() == index) {

                bg = UIManager.getColor("List.dropCellBackground");
                fg = UIManager.getColor("List.dropCellForeground");

                isSelected = true;
            }

            if (isSelected) {
                setBackground(bg == null ? list.getSelectionBackground() : bg);
                setForeground(fg == null ? list.getSelectionForeground() : fg);
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            name.setText(value.getName());
            col1.setText(value.getCol1());
            col2.setText(value.getCol2());

            name.setForeground(getForeground());
            col1.setForeground(getForeground());
            col2.setForeground(getForeground());

            setEnabled(list.isEnabled());

            name.setFont(list.getFont());
            col1.setFont(list.getFont());
            col2.setFont(list.getFont());

            Border border = null;
            if (cellHasFocus) {
                if (isSelected) {
                    border = UIManager.getBorder("List.focusSelectedCellHighlightBorder");
                }
                if (border == null) {
                    border = UIManager.getBorder("List.focusCellHighlightBorder");
                }
            } else {
                border = getNoFocusBorder();
            }
            setBorder(border);

            return this;
        }
    }
}