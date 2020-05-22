import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.MOVE;
import javax.swing.TransferHandler.TransferSupport;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TableSwap {

    public static void main(String[] args) {
        new TableSwap();
    }

    public TableSwap() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTable t1 = createTable(0);
                JTable t2 = createTable(20);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(0, 2));
                frame.add(new JScrollPane(t1));
                frame.add(new JScrollPane(t2));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected JTable createTable(int startAt) {

        DefaultTableModel model = new DefaultTableModel(0, 2);
        for (int index = 0; index < 10; index++) {
            model.addRow(new Object[]{"0x" + (index + startAt), "1x" + (index + startAt)});
        }

        JTable table = new JTable(model);
        table.setDragEnabled(true);
        table.setDropMode(DropMode.USE_SELECTION);
        table.setTransferHandler(new TransferHelper());
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);

        return table;
    }

}