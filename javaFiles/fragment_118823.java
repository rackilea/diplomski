import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.*;

public class EditorRendererClickCountToStart {

    public EditorRendererClickCountToStart() {
        TableModel model = new DefaultTableModel(new Object[][]{
                    {"A", "Item 0"}, {"B", "Item 1"}, {"C", "Item 2"},
                    {"D", "Item 3"}, {"E", "Item 4"}}, new String[]{"TextField", "Combo"});
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultCellEditor editor = new DefaultCellEditor(new JComboBox(new Object[]{
                    "Item 0", "Item 1", "Item 2", "Item 3", "Item 4"}));
        editor.setClickCountToStart(2);
        table.getColumnModel().getColumn(1).setCellEditor(editor);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {// handle exception
        } catch (ClassNotFoundException e) {// handle exception
        } catch (InstantiationException e) {// handle exception
        } catch (IllegalAccessException e) {// handle exception
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new EditorRendererClickCountToStart();
            }
        });
    }
}