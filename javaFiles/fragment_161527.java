import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CellRendererTest
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnNames = {
            "First Name", "Last Name", "Sport" };
        Object[][] data = {
            {"Kathy", "Smith", "Snowboarding" },
            {"John", "Doe", "Rowing" },
            {"Sue", "Black", "Knitting"},
            {"Jane", "White", "Speed reading"},
            {"Joe", "Brown", "Pool"}
        };
        final JTable table = new JTable(data, columnNames);

        final ColoringCellRenderer cellRenderer = new ColoringCellRenderer(); 
        TableColumnModel columnModel = table.getColumnModel();
        int cc = columnModel.getColumnCount();
        for (int c=0; c<cc; c++)
        {
            TableColumn column = columnModel.getColumn(c);
            column.setCellRenderer(cellRenderer);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton addRandomColorButton = new JButton("Add random color");
        addRandomColorButton.addActionListener(new ActionListener()
        {
            private Random random = new Random(0);
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int rows = table.getRowCount();
                int cols = table.getColumnCount();
                int row = random.nextInt(rows);
                int col = random.nextInt(cols);
                int r = random.nextInt(255);
                int g = random.nextInt(255);
                int b = random.nextInt(255);
                cellRenderer.setCellColor(row, col, new Color(r,g,b));
                table.repaint();
            }
        });
        f.getContentPane().add(addRandomColorButton, BorderLayout.SOUTH);

        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}


class ColoringCellRenderer extends DefaultTableCellRenderer
{
    private final Map<Point, Color> cellColors = new HashMap<Point, Color>();

    void setCellColor(int r, int c, Color color)
    {
        if (color == null)
        {
            cellColors.remove(new Point(r,c));
        }
        else
        {
            cellColors.put(new Point(r,c), color);
        }
    }

    private Color getCellColor(int r, int c)
    {
        Color color = cellColors.get(new Point(r,c));
        if (color == null)
        {
            return Color.WHITE;
        }
        return color;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column)
    {
        super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);
        Color color = getCellColor(row, column);
        setBackground(color);
        return this;
    }
}