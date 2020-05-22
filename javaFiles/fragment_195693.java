import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.*;

public class TableIcon extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private JLabel myLabel = new JLabel("waiting");
    private int pHeight = 40;
    private boolean runProcess = true;
    private int count = 0;

    public TableIcon() {
        ImageIcon errorIcon = (ImageIcon) UIManager.getIcon("OptionPane.errorIcon");
        ImageIcon infoIcon = (ImageIcon) UIManager.getIcon("OptionPane.informationIcon");
        ImageIcon warnIcon = (ImageIcon) UIManager.getIcon("OptionPane.warningIcon");
        String[] columnNames = {"Picture", "Description"};
        Object[][] data = {{errorIcon, "About"}, {infoIcon, "Add"}, {warnIcon, "Copy"},};
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable(model);
        table.setRowHeight(pHeight);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        myLabel.setPreferredSize(new Dimension(200, pHeight));
        myLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(myLabel, BorderLayout.SOUTH);
        new Thread(this).start();
    }

    public void run() {
        while (runProcess) {
            try {
                Thread.sleep(1250);
            } catch (Exception e) {
                e.printStackTrace();
            }
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    ImageIcon myIcon = (ImageIcon) table.getModel().getValueAt(count, 0);
                    String lbl = "JTable Row at :  " + count;
                    myLabel.setIcon(myIcon);
                    myLabel.setText(lbl);
                    count++;
                    if (count > 2) {
                        count = 0;
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        TableIcon frame = new TableIcon();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocation(150, 150);
        frame.pack();
        frame.setVisible(true);
    }
}