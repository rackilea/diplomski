import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.*;

@SuppressWarnings("serial")
public class VisibleRows extends JPanel {
    private DefaultListModel<Datum> dataModel = new DefaultListModel<>();
    private JList<Datum> datumList = new JList<>(dataModel);

    public VisibleRows() {
        DataPanel dataPanel = new DataPanel(8);
        for (int i = 0; i < 200; i++) {
            String name = "John Smith " + i;
            int value = i;
            Datum datum = new Datum(name, value);
            dataPanel.addDatum(datum);
            dataModel.addElement(datum);
        }

        JScrollPane scrollPane1 = new JScrollPane(dataPanel);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane1);

        datumList.setVisibleRowCount(8);
        datumList.setCellRenderer(new DatumRenderer());
        datumList.setPrototypeCellValue(new Datum("XXXXXXXXXXX", 200));
        JScrollPane scrollPane2 = new JScrollPane(datumList);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane2);

    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("VisibleRows");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new VisibleRows());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

@SuppressWarnings("serial")
class DatumRenderer extends DatumPanel implements ListCellRenderer<Datum> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Datum> list, Datum value, int index,
            boolean isSelected, boolean cellHasFocus) {
        setDatum(value);
        return this;
    }

}

@SuppressWarnings("serial")
class DataPanel extends JPanel implements Scrollable {
    private int visibleRowCount = 1;

    public DataPanel(int visibleRowCount) {
        this.visibleRowCount = visibleRowCount;
        setLayout(new GridLayout(0, 1));
    }

    public void addDatum(Datum datum) {
        add(new DatumPanel(datum));
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        if (getComponentCount() > 0) {
            JComponent comp = (JComponent) getComponents()[0];
            int width = getPreferredSize().width;
            int height = visibleRowCount * comp.getPreferredSize().height;
            Dimension d = new Dimension(width, height);
            System.out.println(d);
            return d;
        } else {
            return new Dimension(0, 0);
        }
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        if (getComponentCount() > 0) {
            JComponent comp = (JComponent) getComponents()[0];
            Dimension d = comp.getPreferredSize();
            if (orientation == SwingConstants.VERTICAL) {
                return d.height;
            } else {
                return d.width;
            }
        }
        return 0;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        if (getComponentCount() > 0) {
            JComponent comp = (JComponent) getComponents()[0];
            Dimension d = comp.getPreferredSize();
            if (orientation == SwingConstants.VERTICAL) {
                return visibleRowCount * d.height;
            } else {
                return d.width;
            }
        }
        return 0;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

}

@SuppressWarnings("serial")
class DatumPanel extends JPanel {
    private static final int GBC_I = 3;
    private Datum datum;
    private JLabel nameLabel = new JLabel();
    private JLabel valueLabel = new JLabel();

    public DatumPanel() {
        setLayout(new GridBagLayout());
        add(new JLabel("Name:"), createGbc(0, 0));
        add(nameLabel, createGbc(1, 0));
        add(new JLabel("Value:"), createGbc(0, 1));
        add(valueLabel, createGbc(1, 1));
    }

    public DatumPanel(Datum datum) {
        this();
        setDatum(datum);
    }

    public final void setDatum(Datum datum) {
        this.datum = datum;
        nameLabel.setText(datum.getName());
        valueLabel.setText("" + datum.getValue());
    }

    public Datum getDatum() {
        return datum;
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(GBC_I, GBC_I, GBC_I, GBC_I);
        gbc.insets.left = x != 0 ? 3 * GBC_I : GBC_I;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        return gbc;
    }
}

class Datum {
    private String name;
    private int value;

    public Datum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + "\n");
        sb.append("Value: " + value);
        return super.toString();
    }

}