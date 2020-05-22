import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicTextUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;


public class JtabletestOKStackOver {

public static void main(String[] args) {

    JtabletestOKStackOver test = new JtabletestOKStackOver();
    test.go();
}

public void go() {

    //create the frame
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //create a table and add it to a scroll pane in a new tab
    JTable jTable1 = new JTable()

    {
        //  Place cell in edit mode when it 'gains focus'

        public void changeSelection(
                int row, int column, boolean toggle, boolean extend)
        {
            super.changeSelection(row, column, toggle, extend);


            if (column > -1)
            {

                if (editCellAt(row, column))
                {
                    Component editor = getEditorComponent();
                    editor.requestFocusInWindow();
                    if (editor instanceof JTextField) {

                        JTextField jf = (JTextField) editor;
                        jf.select(0, jf.toString().length());
                    }
                    if (editor instanceof JComboBox) {
                        JComboBox jcb = (JComboBox) editor;
                        jcb.setPopupVisible(true);
                        JTextComponent editorCombo = (JTextComponent) jcb.getEditor().getEditorComponent();
                        editorCombo.setSelectionStart(0);
                        editorCombo.setSelectionEnd(editorCombo.getText().length());
                    }



                }
            }
        }
    };





    jTable1.setPreferredScrollableViewportSize(new Dimension(800,100));
    jTable1.setFillsViewportHeight(true);
    jTable1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);

    //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(jTable1);

    Object columnNames[] = { "DataCombo", "Data 2", "Data 3", "Data 4"  };
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    Object rowData[] = { "", "Row1-Column2", "Row1-Column3", "Row1-Column3" };
    model.addRow(rowData);
    jTable1.setModel(model);


    String[] comboBoxArray = {"proem1","veitem2","atem3"};
    JComboBox jca = new JComboBox(comboBoxArray);
    jca.setSelectedItem("");
    JTextComponent editor = (JTextComponent) jca.getEditor().getEditorComponent();

    editor.addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyChar() == KeyEvent.VK_ENTER){
                JComponent ja = (JComponent) e.getSource();
                JComboBox jcbloc = (JComboBox) ja.getParent();
                JTable jtb = (JTable) jcbloc.getParent();
                jtb.changeSelection(0,1,false,false);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    });


    editor.addFocusListener(new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {
            JComponent ja = (JComponent) e.getSource();
            JComponent jcbloc = (JComponent) ja.getParent();
            JComboBox jcb = (JComboBox) jcbloc;
            jcb.setPopupVisible(true);
            JTextComponent editor = (JTextComponent) jcb.getEditor().getEditorComponent();
            editor.setSelectionStart(0);
            editor.setSelectionEnd(editor.getText().length());
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    });





    TableColumn colCombo = jTable1.getColumnModel().getColumn(0);
    jca.setEditable(true);
    comboboxEditor cbe = new comboboxEditor(jca);
    colCombo.setCellEditor(cbe);


    TableColumn colAutre = jTable1.getColumnModel().getColumn(1);
    TableColumn colAutre2 = jTable1.getColumnModel().getColumn(2);
    TableColumn colAutre3 = jTable1.getColumnModel().getColumn(3);
    textCellEditor dce = new textCellEditor(new JTextField());

    colAutre.setCellEditor(dce);
    colAutre2.setCellEditor(dce);
    colAutre3.setCellEditor(dce);



    frame.getContentPane().add(scrollPane);
    frame.pack();
    frame.setVisible(true);

}







class comboboxEditor extends AbstractCellEditor implements TableCellEditor{

    JComboBox comboBox;



    public comboboxEditor(JComboBox jcb) {

        comboBox = jcb;
    }


    public Object getCellEditorValue() {
        return comboBox.getSelectedItem();
    }


    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        comboBox.setSelectedItem(value);
        return comboBox;
    }

    public boolean stopCellEditing() {
        fireEditingStopped();
        return true;

    }


}

class textCellEditor extends AbstractCellEditor implements TableCellEditor{
    JTextField jtextfield;

    public textCellEditor(JTextField jtf) {
        jtextfield = jtf;
    }


    public Object getCellEditorValue() {
        return jtextfield.getText();
    }


    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            // cell (and perhaps other cells) are selected
        }
        if (value== null)
        {
            value="";
        }
        value = value.toString();
        if (value instanceof Integer) {
            value = value.toString();
        }
        jtextfield.setText((String) value);

        // Return the configured component
        return jtextfield;
    }

    public boolean stopCellEditing() {
        fireEditingStopped();
        return true;

    }

}



}