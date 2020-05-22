package spelmeny.table;

import java.awt.Component;
import java.util.Enumeration;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import spelmeny.logik.GameModel;
import spelmeny.style.GameStyle;

/**
*
* @author stefan santesson
*/
public class OthelloTable {

JTable table;
GameModel gameModel;
DefaultTableModel tm;
String[] heading = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
GameStyle style;

public OthelloTable(JTable table, GameModel gameModel, GameStyle style) {
    this.table = table;
    table.setRowHeight(GameStyle.CELL_SIZE);
    this.gameModel = gameModel;
    this.style = style;
}

public void setStyle(GameStyle style) {
    this.style = style;
}

public void updateTable() {
    int colCount = table.getColumnModel().getColumnCount();
    Object[][] tableVal = new Object[colCount][8];
    int[][] board = gameModel.getBoardData();
    for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
            tableVal[row][col] = board[row][col];
        }
    }
    for (int row = 0; row < 8; row++) {
        for (int col = 0; col < colCount; col++) {
            tm.setValueAt(tableVal[row][col], row, col);
        }
    }
}

public void setTable() {
    tm = new MyTableModel(heading);
    IconRenderer icnRenderer = new IconRenderer();
    int[][] board = gameModel.getBoardData();

    for (int row = 0; row < 8; row++) {
        Object[] rowData = new Object[8];
        for (int col = 0; col < 8; col++) {
            rowData[col] = board[row][col];
        }
        tm.addRow(rowData);
    }

    table.setModel(tm);
    Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
    for (int colIndex = 0; colIndex < 8; colIndex++) {
        TableColumn cbCol = table.getColumnModel().getColumn(colIndex);
        cbCol.setCellRenderer(icnRenderer);
        columns.nextElement().setPreferredWidth(GameStyle.CELL_SIZE);
    }
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
}

class MyTableModel extends DefaultTableModel {

    public MyTableModel(Object[] os) {
        super();
        for (Object o : os) {
            addColumn(o);
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            default:
                return Integer.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}

class IconRenderer extends DefaultTableCellRenderer {

    public IconRenderer() {
        super();
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Integer) {
            switch ((Integer) value) {
                case GameModel.BLACK:
                    setIcon(style.getBlackIcn());
                    break;
                case GameModel.WHITE:
                    setIcon(style.getWhiteIcn());
                    break;
                case GameModel.POSSIBLE:
                    setIcon(style.getPossibleIcn());
                    break;
                default:
                    setIcon(style.getEmptyIcn());
            }
        }

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Object firstColumnValue = table.getValueAt(row, 0);

        setVerticalAlignment(JLabel.TOP);
        setValue(value);
        setBackground(table.getBackground());
        setForeground(table.getForeground());
        return this;
    }
}