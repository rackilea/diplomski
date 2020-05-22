import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

public class Test {

    public Test() {
        String[][] data = {
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"},
            {"sdvjdnvdfjvnsdvsdjvs", "sdvjdnvdfjvnsdvsdjvsdvkdsjvnbdvlkjvnbdkvdvkdjvvsnvlkdnv"}};

        String[] cols = {"COL 1", "COL 2"};

        final JTable moves = new JTable(data, cols);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {

            public Component getTableCellRendererComponent(JTable table,
                    Object obj, boolean isSelected, boolean hasFocus, int row, int column) {

                Component rendererComp = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus,
                        row, column);
                if (column == 1) {
                    JTextArea text = new JTextArea(obj.toString(), 2, 20);
                    text.setFont(rendererComp.getFont());
                    text.setLineWrap(true);
                    text.setWrapStyleWord(true);
                    text.setSize(text.getSize().width, text.getPreferredSize().height);
                    table.setRowHeight(row, text.getPreferredSize().height);
                    return text;
                } else {
                    return rendererComp;
                }
            }
        };

        moves.setDefaultRenderer(Object.class, renderer);

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(moves));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test test = new Test();
            }
        });
    }
}