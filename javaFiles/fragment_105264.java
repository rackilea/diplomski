import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import general.VerticalTableHeaderCellRenderer;
import java.awt.Color;
import java.util.Random;
import javax.swing.table.TableCellRenderer;

//  The class of template for table's presentation of knowledge
//==============================================================================    
public class ExcelTable extends JFrame {

    public static int rowCount = 1024;
    public static int colCount = 1024;
    public static int CHLength = 100;
    public static int RWLength = 50;
    public static int DCW = 20;

//  The constructor of this class
//==============================================================================    
    public ExcelTable() {
        super("Draw cell rotate");
        setSize(400, 400);

        //The abstract model of table's presentation
        ListModel lm = new AbstractListModel() {
            String[] headers = new String[rowCount];

            @Override
            public int getSize() {
                return headers.length;
            }

            @Override
            public Object getElementAt(int index) {
                return headers[index];

            }
        };

        DefaultTableModel dtm = new DefaultTableModel(lm.getSize(), colCount);
        JTable table = new JTable(dtm) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, col);
                setCellSelectionEnabled(true);

// Here you can write you schemes
                final Random r = new Random();
                Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256));

                if (getSelectedRow() != 0) {
                    if (row % 2 == 0 && col % 2 == 1) {
                        comp.setBackground(c);
                    } else if (row % 2 == 1 && row % 2 == 1) {
                        comp.setBackground(c);
                    } else {
                        comp.setBackground(c);
                    }
                } else {
                    comp.setBackground(Color.white);
                }
                return comp;
            }
        };
        table.getTableHeader().setDefaultRenderer(new VerticalTableHeaderCellRenderer());
        for (int i = 0; i < colCount; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(DCW);// .setTotalColumnWidth();
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.setCellSelectionEnabled(true);

        // Create header rotation
        JList rowHeader = new JList(lm);
        // if (fieldlength)
        rowHeader.setFixedCellWidth(RWLength); //RowHeaser width
        rowHeader.setFixedCellHeight(table.getRowHeight());

        //Set render
        rowHeader.setCellRenderer(new RowRenderer(table));

        //JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setColumnHeader(new JViewport() {
            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = CHLength;  // Col header Height
                return d;
            }
        });
        pane.setRowHeaderView(rowHeader);
        getContentPane().add(pane, BorderLayout.CENTER);

    }

//=========================================
    public static void main(String[] args) {
        ExcelTable jr = new ExcelTable();
        jr.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jr.setVisible(true);
    }
}

class RowRenderer extends JLabel implements ListCellRenderer {

    public RowRenderer(JTable table) {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}