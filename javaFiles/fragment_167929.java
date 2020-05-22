import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class DepartmentCellEditor extends DefaultCellEditor
{
  public DepartmentCellEditor()
  {
    super( new JTextField() );
  }

  public boolean stopCellEditing()
  {
    JTable table = (JTable)getComponent().getParent();

    try
    {
      boolean isValid = true;
      String s = getCellEditorValue().toString();
      if ( s.length() == 3 ) {
        for ( int i = 0; i < s.length(); i++ ) {
          if ( !Character.isDigit( s.charAt( i ) ) ) {
            isValid = false;
            break;
          }
        }
      } else {
        isValid = false;
      }
      if ( !isValid ) {

        JTextField textField = (JTextField)getComponent();
        textField.setBorder(new LineBorder(Color.red));
        textField.selectAll();
        textField.requestFocusInWindow();
           /*JOptionPane.showMessageDialog(
          null,
         "Please enter a 3 digit number.",
           "Alert!",JOptionPane.ERROR_MESSAGE);*/
      } else {
        JTextField textField = (JTextField)getComponent();
        textField.setBorder(new LineBorder(Color.black));
      }
      return isValid && super.stopCellEditing(); //THIS IS THE CHANGE
    }
    catch(ClassCastException exception)
    {
      JTextField textField = (JTextField)getComponent();
      textField.setBorder(new LineBorder(Color.red));
      textField.selectAll();
      textField.requestFocusInWindow();
      return false;
    }
  }

  public Component getTableCellEditorComponent(
      JTable table, Object value, boolean isSelected, int row, int column)
  {
    Component c = super.getTableCellEditorComponent(
        table, value, isSelected, row, column);
    ((JComponent)c).setBorder(new LineBorder(Color.black));

    return c;
  }

  public static void main(String[] args)
  {
    JTable table = new JTable(new String[][] {{"111", "222"}, {"", ""}}, new String[] {"A", "B"});
    table.getColumn("A").setCellEditor(new DepartmentCellEditor());
    table.getColumn("B").setCellEditor(new DepartmentCellEditor());

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new JScrollPane(table));
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
  }
}