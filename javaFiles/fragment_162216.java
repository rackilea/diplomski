import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;

public class ComboTest {

JTable table;
JComboBox comboBox;

ComboTest(){
    String[] headings = {"Type", "Reference Number", "Amount"};
    Object[][] data = {
            {"Cash", "123", "2000"},
            {"Online", "333", "1200"},
            {"Bank Transfer", "667", "800"}
    };
    comboBox = new JComboBox(new String[] {"Cash", "Cheque", "Bank Transfer", "Credit Card", "Online"});
    AutoCompleteDecorator.decorate(comboBox);       
    JFrame jfrm = new JFrame("Example");
    jfrm.getContentPane().setLayout(new FlowLayout());
    jfrm.setSize(500, 160);
    table = new JTable(data, headings);
    table.setSelectionBackground(Color.GREEN);      
    TableColumn ledgerColumn = table.getColumnModel().getColumn(0);
    ledgerColumn.setCellEditor(new ComboBoxCellEditor(comboBox));
//This is the code that changes the colour of the combo Box when it is selected.
    comboBox.getEditor().getEditorComponent().addFocusListener(new FocusListener() {
        public void focusGained(FocusEvent arg0) {
            comboBox.getEditor().getEditorComponent().setBackground(Color.GREEN);
        }
        public void focusLost(FocusEvent arg0) {
            comboBox.getEditor().getEditorComponent().setBackground(Color.WHITE);
        }
    });
    JScrollPane jscrlp = new JScrollPane(table);
    jfrm.getContentPane().add(jscrlp);
    jfrm.setVisible(true);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable () {
        public void run() {
            new ComboTest();
        }
    });

}

}