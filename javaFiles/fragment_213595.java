package own_components.custom_components;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.View;

public class OutputJTable extends JTable
{
    private static final long serialVersionUID = 1L;
private List<String[]> data = new ArrayList<String[]>();
private CustomTableModel dataModel = new CustomTableModel();

private final int COLUMNS_AMOUNT = 3;
private final int _1ST_COL_WIDTH = 25;
private final int _2ST_COL_WIDTH = 45;
private final int _3ND_COL_WIDTH = 505;

private int selectedRow = -1;


public OutputJTable()
{
    setModel(dataModel);
    setDefaultRenderer(Object.class, new CustomTableRenderer());
    setTableProperties();
}


/**
 * Sets basic table properties.
 */
private void setTableProperties()
{
    setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    getColumnModel().getColumn(0).setMaxWidth(_1ST_COL_WIDTH);
    getColumnModel().getColumn(0).setMinWidth(_1ST_COL_WIDTH);
    getColumnModel().getColumn(1).setMaxWidth(_2ST_COL_WIDTH);
    getColumnModel().getColumn(1).setMinWidth(_2ST_COL_WIDTH);
    getColumnModel().getColumn(2).setMaxWidth(_3ND_COL_WIDTH);
    getColumnModel().getColumn(2).setMinWidth(_3ND_COL_WIDTH);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    setIntercellSpacing(new Dimension(0, 0));
    setShowGrid(false);
}


/**
 * Receives data used to modified data showned in table.
 * This should be only access point to add data used by data model (which is used by jtable).
 * 
 * @param result
 */
public void setResultOutput(List<String[]> result)
{
    data = new ArrayList<String[]>();
    data = result;
    dataModel.fireTableDataChanged();
}


@Override
public void doLayout()
{
    super.doLayout();
    for (int row = 0; row < getRowCount(); row++)
    {
        JTextArea a = (JTextArea) prepareRenderer(getDefaultRenderer(Object.class), row, 2);
        int rowHeight = (int) a.getUI().getRootView(a).getView(0).getPreferredSpan(View.Y_AXIS) + getIntercellSpacing().height;
        setRowHeight(row, rowHeight);
    }
}


/**
 * Returns which row is selected. Main purpose of this method is provide data to PrintManager what should be printed.
 */
public int getSelectedRow()
{
    return selectedRow;
}


@Override
public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend)
{
    if (rowIndex != selectedRow)
    {
        selectedRow = rowIndex;
    }
    else
    {
        selectedRow = -1;
    }
    super.changeSelection(rowIndex, columnIndex, true, false);
}


/**
 * This is model used to fill this table with data.
 */
private class CustomTableModel extends DefaultTableModel implements LocalizableComponent
{
    private static final long serialVersionUID = -992340559233338699L;
    private String[] columnsNames = { "a", "b", "c" };


    @Override
    public String getColumnName(int paramInt)
    {
        return columnsNames[paramInt];
    }


    @Override
    public boolean isCellEditable(int paramInt1, int paramInt2)
    {
        return false;
    }


    @Override
    public int getColumnCount()
    {
        return COLUMNS_AMOUNT;
    }


    @Override
    public int getRowCount()
    {
        return data.size();
    }


    @Override
    public String getValueAt(int arg0, int arg1)
    {
        return data.get(arg0)[arg1];
    }

}

/**
 * This class is used to render single cell.
 */
private class CustomTableRenderer extends JTextArea implements TableCellRenderer
{
    private final Color SELECTION_BORDER = new Color(200, 200, 200);
    private final Color ODD_BACKGR_COLOR = new Color(240, 240, 240);
    private final Color EVEN_BACKGR_COLOR = Color.WHITE;


    CustomTableRenderer()
    {
        setLineWrap(true);
        setWrapStyleWord(true);
        setEditable(false);
        setFont(getFont());
    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        setText((String) value);

        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                    if (isSelected)
        {
            setBackground(SELECTION_BORDER);
        }
        else if (row % 2 != 0)
        {
            setBackground(ODD_BACKGR_COLOR);
        }
        else
        {
            setBackground(EVEN_BACKGR_COLOR);
        }
        return this;
    }
}
}