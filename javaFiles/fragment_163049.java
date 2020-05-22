import java.awt.BorderLayout;
    import java.util.Properties;
    import javax.swing.*;
    import javax.swing.tree.TreeCellEditor;

    public class TreeEditJComboBox {

        public static void main(String args[]) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Properties props = System.getProperties();
            JTree tree = new JTree(props);


            JComboBox comboBox = new JComboBox(new String[]{"A", "B", "C"});
            TreeCellEditor editor = new DefaultCellEditor(comboBox);

            tree.setEditable(true);
            tree.setCellEditor(editor);

            JScrollPane scrollPane = new JScrollPane(tree);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(300, 150);
            frame.setVisible(true);
        }

    }
}