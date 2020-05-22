import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

public class ClientOverviewTest {
   private static void createAndShowGui() {
      ClientOverviewPanel2 mainPanel = new ClientOverviewPanel2();

      JFrame frame = new JFrame("ClientOverviewPanel");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
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

class ClientOverviewPanel2 extends JPanel {
   private static final int CLIENTS = 5;
   private static final int PREF_W = 600;
   private static final int PREF_H = 200;
   private ClientTableModel model = new ClientTableModel();
   private JTable table = new JTable(model);

   public ClientOverviewPanel2() {
      for (int i = 0; i < CLIENTS; i++) {
         String ip = "127.000.000.001";
         UUID uuid = UUID.randomUUID();
         boolean isLocal = true;
         SingleClient client = new SingleClient(ip, uuid, isLocal);
         model.addRow(client);
      }

      table.getColumnModel().getColumn(1).setPreferredWidth(150); //!!
      table.setPreferredScrollableViewportSize(table.getPreferredSize());

      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      setLayout(new BorderLayout());
      add(scrollPane, BorderLayout.CENTER);
      add(new JButton(new OkAction("OK")), BorderLayout.PAGE_END);

   }

   @Override
   public Dimension getPreferredSize() {
      Dimension superSz = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSz;
      }
      int prefW = PREF_W;
      int prefH = Math.min(superSz.height, PREF_H);
      return new Dimension(prefW, prefH);
   }


   private class OkAction extends AbstractAction {
      public OkAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Component source = (Component) e.getSource();
         Window window = SwingUtilities.getWindowAncestor(source);
         if (window != null) {
            window.dispose();
         }
      }
   }
}

class ClientTableModel extends AbstractTableModel {
   public final static String[] COLUMNS = { "IP", "UUID", "Local" };
   private List<SingleClient> clientList = new ArrayList<>();

   @Override
   public int getColumnCount() {
      return COLUMNS.length;
   }

   @Override
   public int getRowCount() {
      return clientList.size();
   }

   @Override
   public String getColumnName(int column) {
      return COLUMNS[column];
   }

   public void addRow(SingleClient client) {
      clientList.add(client);
      int index = clientList.size() - 1;
      fireTableRowsInserted(index, index);
   }

   @Override
   public Object getValueAt(int rowIndex, int columnIndex) {
      if (rowIndex >= getRowCount() || rowIndex < 0) {
         String text = "for rowIndex: " + rowIndex;
         throw new IllegalArgumentException(text);
      }
      if (columnIndex < 0 || columnIndex >= COLUMNS.length) {
         String text = "for columnIndex: " + columnIndex;
         throw new IllegalArgumentException(text);
      }
      SingleClient client = clientList.get(rowIndex);
      switch (columnIndex) {
      case 0:
         return client.getIp();
      case 1:
         return client.getUuid();
      case 2:
         return client.isLocal();
      }
      return null;
   }

   @Override
   public Class<?> getColumnClass(int columnIndex) {
      if (columnIndex < 0 || columnIndex >= COLUMNS.length) {
         String text = "for columnIndex: " + columnIndex;
         throw new IllegalArgumentException(text);
      }

      switch (columnIndex) {
      case 0:
         return String.class;
      case 1: 
         return UUID.class;
      case 2:
         return Boolean.class;
      }

      // default value
      return super.getColumnClass(columnIndex);
   }

   @Override
   public boolean isCellEditable(int rowIndex, int columnIndex) {
      return columnIndex == 2;
   }

   @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      SingleClient client = clientList.get(rowIndex);
      switch (columnIndex) {
      case 0:
         break;
      case 1:
         break;
      case 2:
         boolean isLocal = (boolean) aValue; 
         client.setLocal(isLocal);

      default:
         break;
      }
   }
}

class SingleClient {
   private String ip;
   private UUID uuid;
   private boolean isLocal;

   public SingleClient(String ip, UUID uuid2, boolean isLocal) {
      this.ip = ip;
      this.uuid = uuid2;
      this.isLocal = isLocal;
   }

   public String getIp() {
      return ip;
   }

   public void setIp(String ip) {
      this.ip = ip;
   }

   public UUID getUuid() {
      return uuid;
   }

   public void setUuid(UUID uuid) {
      this.uuid = uuid;
   }

   public boolean isLocal() {
      return isLocal;
   }

   public void setLocal(boolean isLocal) {
      this.isLocal = isLocal;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((ip == null) ? 0 : ip.hashCode());
      result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      SingleClient other = (SingleClient) obj;
      if (ip == null) {
         if (other.ip != null)
            return false;
      } else if (!ip.equals(other.ip))
         return false;
      if (uuid == null) {
         if (other.uuid != null)
            return false;
      } else if (!uuid.equals(other.uuid))
         return false;
      return true;
   }

}