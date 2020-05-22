import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.*;

public class AlbumTrackTable {

    private JComponent ui = null;
    String[][] playList = {
        {"The Will to Live", "Faded"},
        {"The Will to Live", "Homeless Child"},
        {"Oh Mercy", "Political Wrold"},
        {"Oh Mercy", "What Was it You Wanted?"},
        {"Red Sails in the Sunset", "Helps Me Helps You"},
        {"Red Sails in the Sunset", "Redneck Wonderland"}
    };
    String[] columnNames = {"Album", "Track"};

    AlbumTrackTable() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        DefaultTableModel trackModel = new DefaultTableModel(playList, columnNames);
        JTable table = new JTable(trackModel);
        ui.add(new JScrollPane(table));
        TableCellRenderer renderer = new TrackCellRenderer();
        table.setDefaultRenderer(Object.class, renderer);
        table.setAutoCreateRowSorter(true);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                AlbumTrackTable o = new AlbumTrackTable();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class TrackCellRenderer extends DefaultTableCellRenderer {

    HashMap<String, Color> colorMap = new HashMap<>();
    Random r = new Random();

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        JLabel l = (JLabel) c;

        String s = (String) value;
        if (column == 0) {
            if (!colorMap.containsKey(s)) {
                Color clr = new Color(
                        150 + r.nextInt(105),
                        150 + r.nextInt(105),
                        150 + r.nextInt(105));
                colorMap.put(s, clr);
            }
            Color color = colorMap.get(s);
            l.setBackground(color);
            l.setOpaque(true);
        } else {
            l.setOpaque(false);
        }

        return l;
    }
}