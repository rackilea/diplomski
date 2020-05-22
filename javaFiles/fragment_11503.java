import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class DnDTest {
  public JComponent makeUI() {
    JTable table = new JTable(5, 3);
    table.setAutoCreateRowSorter(true);
    table.setTransferHandler(new ToTransferHandler());

    JLabel label = new JLabel("aaaaaaaaaaaa");
    label.setTransferHandler(new TransferHandler("text"));
    label.addMouseListener(new MouseAdapter() {
      @Override public void mousePressed(MouseEvent e) {
        JComponent c = (JComponent) e.getSource();
        c.getTransferHandler().exportAsDrag(c, e, TransferHandler.COPY);
      }
    });

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(table));
    p.add(label, BorderLayout.SOUTH);
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new DnDTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

//@see https://docs.oracle.com/javase/tutorial/uiswing/dnd/dropactiondemo.html
class ToTransferHandler extends TransferHandler {
  @Override public boolean canImport(TransferHandler.TransferSupport support) {
    return getPropertyDataFlavor(String.class, support.getDataFlavors()) != null;
  }
  @Override public boolean importData(TransferHandler.TransferSupport support) {
    // if we can't handle the import, say so
    if (!canImport(support)) {
      return false;
    }

    DataFlavor flavor = getPropertyDataFlavor(String.class, support.getDataFlavors());

    // fetch the data and bail if this fails
    String data;
    try {
      data = (String) support.getTransferable().getTransferData(flavor);
    } catch (UnsupportedFlavorException | java.io.IOException e) {
      return false;
    }

    JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
    JTable table = (JTable) support.getComponent();
    table.setValueAt(data, dl.getRow(), dl.getColumn());
    return true;
  }
  //@see TransferHandler.java private DataFlavor getPropertyDataFlavor(...) {
  private DataFlavor getPropertyDataFlavor(Class<?> k, DataFlavor[] flavors) {
    for (int i = 0; i < flavors.length; i++) {
      DataFlavor flavor = flavors[i];
      if ("application".equals(flavor.getPrimaryType()) &&
          "x-java-jvm-local-objectref".equals(flavor.getSubType()) &&
          k.isAssignableFrom(flavor.getRepresentationClass())) {
        return flavor;
      }
    }
    return null;
  }
}