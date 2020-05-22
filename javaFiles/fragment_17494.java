import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TableWithAlternatingColorsExample {
    @SuppressWarnings("serial")
    private static class AlternatingColorOnKeyRenderer extends DefaultTableCellRenderer {
        /* The alternating colors */
        public static final Color color1 = new Color(204,204,204);
        public static final Color color2 = new Color(255,255,255);

        /** The model index of the key column, ie the model column from which the key is derived. */
        public static final int modelKeyColId = 0;

        /** The color store that stores the colors for each row in the view. 
         *  Indexed with view index to retrieve color for a row in the view. */
        private ArrayList<Color> colorStore = new ArrayList<>( );

        /** Reset all colors in the color store. */
        public void resetAllColors() {
            colorStore = new ArrayList<>(Math.max(10,colorStore.size()));
        }

        /** Reset all colors in the color store from a certain view index on. */
        public void resetColorsFrom(int row) {
            if(row==0) 
                resetAllColors();
            else {
                ArrayList<Color> retainedColors = new ArrayList<>(Math.max(10,colorStore.size()));
                retainedColors.addAll(colorStore.subList(0,Math.min(row-1,colorStore.size()-1)));  // copy retained colors
                colorStore = retainedColors;
            }
        }

        /** Determines the key value from a cell value. */
        private Object getCellKeyVal(Object cellValue) {
            return new StringTokenizer(cellValue.toString(),":").nextElement();
        }

        /** Retrieves the key value for a certain row. */
        private Object getRowKeyVal(JTable t,int viewRowId) {
            int modelRowId = t.convertRowIndexToModel(viewRowId);                 // convert row view index to model index to index the model
            Object cellValue = t.getModel().getValueAt(modelRowId,modelKeyColId); // get cell value from model, because the column might not be present in the view
            return getCellKeyVal(cellValue);
        }

        /** Prepares the color store for a certain row in the view. 
         *  After calling this method colors for the range [0,row] will be present in the color store. 
         *  Call this method to ensure that <i>colorStore.get(row)</i> will return a color. */
        private void prepareColorStore(JTable t,int row) {
            if(colorStore.size()>row) return;                            // color already present for row
            if(colorStore.isEmpty()) colorStore.add(color1);             // if color store empty, start with the first color
            if(row==0) return;
            Object curKeyVal = getRowKeyVal(t,colorStore.size()-1);
            while(colorStore.size()<=row) {                              // add colors until color present for row
                Object prevKeyVal = curKeyVal;
                curKeyVal = getRowKeyVal(t,colorStore.size());
                if(prevKeyVal.equals(curKeyVal))                         // compare key values between current and previous row
                    colorStore.add(colorStore.get(colorStore.size()-1)); // add previous color in store when key values are equal
                else if(colorStore.get(colorStore.size()-1)==color1)     // reference compare because color instances are fixed
                    colorStore.add(color2);                              // add alternating color when key values differ
                else
                    colorStore.add(color1);
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
            Component c = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
            if(!table.isRowSelected(row)) {
                prepareColorStore(table,row);         // ensure color is present for row
                c.setBackground(colorStore.get(row)); // set color from color store
            }
            return c;
        }
    };

    private static JTable createTable() {
        Vector<Vector<Object>> rowData = new Vector<>( Arrays.asList( 
            new Vector<>(Arrays.asList(new Object[]{"ticket0:0::","ticket0:0::","ticket0:0::","ticket0:0::","ticket0:0::","ticket0:0::","ticket0:0::","ticket0:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket25:1::","ticket25:1::","ticket25:1::","ticket25:1::","ticket25:1::","ticket25:1::","ticket25:1::","ticket25:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket0:1::","ticket0:1::","ticket0:1::","ticket0:1::","ticket0:1::","ticket0:1::","ticket0:1::","ticket0:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket1:0::","ticket1:0::","ticket1:0::","ticket1:0::","ticket1:0::","ticket1:0::","ticket1:0::","ticket1:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket1:1::","ticket1:1::","ticket1:1::","ticket1:1::","ticket1:1::","ticket1:1::","ticket1:1::","ticket1:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket10:0::","ticket10:0::","ticket10:0::","ticket10:0::","ticket10:0::","ticket10:0::","ticket10:0::","ticket10:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket10:1::","ticket10:1::","ticket10:1::","ticket10:1::","ticket10:1::","ticket10:1::","ticket10:1::","ticket10:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket11:0::","ticket11:0::","ticket11:0::","ticket11:0::","ticket11:0::","ticket11:0::","ticket11:0::","ticket11:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket11:1::","ticket11:1::","ticket11:1::","ticket11:1::","ticket11:1::","ticket11:1::","ticket11:1::","ticket11:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket12:0::","ticket12:0::","ticket12:0::","ticket12:0::","ticket12:0::","ticket12:0::","ticket12:0::","ticket12:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket12:1::","ticket12:1::","ticket12:1::","ticket12:1::","ticket12:1::","ticket12:1::","ticket12:1::","ticket12:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket13:0::","ticket13:0::","ticket13:0::","ticket13:0::","ticket13:0::","ticket13:0::","ticket13:0::","ticket13:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket13:1::","ticket13:1::","ticket13:1::","ticket13:1::","ticket13:1::","ticket13:1::","ticket13:1::","ticket13:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket14:0::","ticket14:0::","ticket14:0::","ticket14:0::","ticket14:0::","ticket14:0::","ticket14:0::","ticket14:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket17:0::","ticket17:0::","ticket17:0::","ticket17:0::","ticket17:0::","ticket17:0::","ticket17:0::","ticket17:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket14:1::","ticket14:1::","ticket14:1::","ticket14:1::","ticket14:1::","ticket14:1::","ticket14:1::","ticket14:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket15:0::","ticket15:0::","ticket15:0::","ticket15:0::","ticket15:0::","ticket15:0::","ticket15:0::","ticket15:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket15:1::","ticket15:1::","ticket15:1::","ticket15:1::","ticket15:1::","ticket15:1::","ticket15:1::","ticket15:1::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket16:0::","ticket16:0::","ticket16:0::","ticket16:0::","ticket16:0::","ticket16:0::","ticket16:0::","ticket16:0::"})),
            new Vector<>(Arrays.asList(new Object[]{"ticket16:1::","ticket16:1::","ticket16:1::","ticket16:1::","ticket16:1::","ticket16:1::","ticket16:1::","ticket16:1::"}))
        ));
        Vector<Object> colData = new Vector<>(Arrays.asList(new Object[]{"1:103:Wed","2:106:Sat","3:110:Wed","4:110:Sat","5:117:Wed","6:120:Sat","7:124:Wed","8:127:Sat"}));
        final JTable t = new JTable(rowData,colData);

        DefaultTableCellRenderer tcr = new AlternatingColorOnKeyRenderer(); 
        Enumeration<TableColumn> e = t.getColumnModel().getColumns();
        while(e.hasMoreElements()) 
            e.nextElement().setCellRenderer(tcr); // all table columns share the same AlternatingColorOnKeyRenderer instance

        t.setAutoCreateRowSorter(true); 
        /* When the row sorter changes, reset all colors in the color store.
         * When row sorting changes, the row view indices will point to different rows in the model, so the color store needs to be reset. */
        t.getRowSorter().addRowSorterListener(new RowSorterListener() {
            @Override
            public void sorterChanged(RowSorterEvent e) {
                ((AlternatingColorOnKeyRenderer) t.getColumnModel().getColumn(0).getCellRenderer()).resetAllColors(); // all rows share the same AlternatingColorOnKeyRenderer instance, so pick the renderer from the first column and reset color store
            }
        });

        /* Add a model listener to listen for inserted/deleted/updated rows. When rows are inserted/deleted/updated, the row colors could change for subsequent rows. 
         * Determines the minimum view index for the inserted/deleted/updated rows, then resets the color store from that view index on. */
        t.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int minViewId;
                switch(e.getType()) {
                    case TableModelEvent.INSERT:
                    case TableModelEvent.DELETE:
                        minViewId = Integer.MAX_VALUE;
                        for(int r=e.getFirstRow();r<=e.getLastRow();++r) { // determine minimum view index for inserted/deleted rows
                            int viewId=t.convertRowIndexToView(r);         // convert model index to view index
                            if(viewId>=0 && viewId<minViewId)              // due to filtering, it is possible that inserted/deleted rows are not visible in the view (convert will return -1 in that case)
                                minViewId=viewId;
                        }
                        if(minViewId!=Integer.MAX_VALUE)                   // if any of the inserted/deleted rows were visible, reset the color store from the minimum view index on  
                            ((AlternatingColorOnKeyRenderer) t.getColumnModel().getColumn(0).getCellRenderer()).resetColorsFrom(minViewId);
                        break;

                    case TableModelEvent.UPDATE:
                        int r = e.getFirstRow();
                        if(r==TableModelEvent.HEADER_ROW)
                            return;                                        // outside scope for this example
                        if(e.getColumn()!=TableModelEvent.ALL_COLUMNS && e.getColumn()!=AlternatingColorOnKeyRenderer.modelKeyColId)
                            return;                                        // only listen for updates in the key column
                        minViewId = Integer.MAX_VALUE;
                        for( ;r<=e.getLastRow();++r) {                     // determine minimum view index for updated rows
                            int viewId=t.convertRowIndexToView(r);         // convert model index to view index
                            if(viewId>=0 && viewId<minViewId)              // due to filtering, it is possible that updated rows are not visible in the view (convert will return -1 in that case)
                                minViewId=viewId;
                        }
                        if(minViewId!=Integer.MAX_VALUE) {                 // if any of the updated rows were visible, reset the color store from the minimum view index on & repaint
                            ((AlternatingColorOnKeyRenderer) t.getColumnModel().getColumn(0).getCellRenderer()).resetColorsFrom(minViewId);
                            t.repaint();                                   // repaint necessary for UPDATE events to update colors in the view
                        }
                        break;
                }
            }
        });

        return t;
    }

    protected static JButton createAddButton(final JTable t) {
        JButton button = new JButton("Add row randomly");
        button.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) t.getModel();
                Vector<Object> newRow = new Vector<>(Arrays.asList(new Object[]{"ticket77:0::","ticket77:0::","ticket77:0::","ticket77:0::","ticket77:0::","ticket77:0::","ticket77:0::","ticket77:0::"}));
                int index = new Random().nextInt(t.getRowCount()+1); // random index to insert
                if(index<t.getRowCount())
                    dtm.getDataVector().add(index,newRow);           // use the dataVector from DefaultTableModel to insert
                else
                    dtm.getDataVector().add(newRow);
                dtm.fireTableRowsInserted(index,index);              // notify the view that a row was inserted
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setLayout(new BorderLayout());
                JTable t = createTable();
                f.add(new JScrollPane(t),BorderLayout.CENTER);
                f.add(createAddButton(t),BorderLayout.SOUTH);
                f.setSize(500, 500);
                f.setVisible(true);
            }
        });
    }
}