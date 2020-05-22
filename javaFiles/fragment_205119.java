import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;

public class LabelHeaderSample {

    public static void main(String args[]) {
        Icon redIcon = new DiamondIcon(Color.red);
        Icon blueIcon = new DiamondIcon(Color.blue);
        Object rows[][] = {{"one", "ichi - \u4E00", new DiamondIcon(Color.red)},
            {"two", "ni - \u4E8C", new DiamondIcon(Color.red)},
            {"three", "san - \u4E09", new DiamondIcon(Color.red)},
            {"four", "shi - \u56DB", new DiamondIcon(Color.red)},
            {"five", "go - \u4E94", new DiamondIcon(Color.red)},
            {"six", "roku - \u516D", new DiamondIcon(Color.red)},
            {"seven", "shichi - \u4E03", new DiamondIcon(Color.red)},
            {"eight", "hachi - \u516B", new DiamondIcon(Color.red)},
            {"nine", "kyu - \u4E5D", new DiamondIcon(Color.red)},
            {"ten", "ju - \u5341", new DiamondIcon(Color.red)}};
        JFrame frame = new JFrame("Label Header");
        String headers[] = {"English", "Japanese", "Icon"};
        JTable table = new JTable(rows, headers);
        JScrollPane scrollPane = new JScrollPane(table);
        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
        JLabel blueLabel = new JLabel(headers[0], blueIcon, JLabel.CENTER);

        blueLabel.setBorder(null);// < - - - here you set Borders

        JLabel redLabel = new JLabel(headers[1], redIcon, JLabel.CENTER);
        redLabel.setBorder(headerBorder);
        TableCellRenderer renderer = new JComponentTableCellRenderer();
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn column0 = columnModel.getColumn(0);
        TableColumn column1 = columnModel.getColumn(1);
        TableColumn column2 = columnModel.getColumn(2);
        column0.setHeaderRenderer(renderer);
        column0.setHeaderValue(blueLabel);
        column1.setHeaderRenderer(renderer);
        column1.setHeaderValue(redLabel);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private LabelHeaderSample() {
    }
}

class DiamondIcon implements Icon {

    private Color color;
    private boolean selected;
    private int width;
    private int height;
    private Polygon poly;
    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 10;

    public DiamondIcon(Color color) {
        this(color, true, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public DiamondIcon(Color color, boolean selected) {
        this(color, selected, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public DiamondIcon(Color color, boolean selected, int width, int height) {
        this.color = color;
        this.selected = selected;
        this.width = width;
        this.height = height;
        initPolygon();
    }

    private void initPolygon() {
        poly = new Polygon();
        int halfWidth = width / 2;
        int halfHeight = height / 2;
        poly.addPoint(0, halfHeight);
        poly.addPoint(halfWidth, 0);
        poly.addPoint(width, halfHeight);
        poly.addPoint(halfWidth, height);
    }

    public int getIconHeight() {
        return height;
    }

    public int getIconWidth() {
        return width;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.translate(x, y);
        if (selected) {
            g.fillPolygon(poly);
        } else {
            g.drawPolygon(poly);
        }
        g.translate(-x, -y);
    }
}

class JComponentTableCellRenderer implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        return (JComponent) value;
    }
}