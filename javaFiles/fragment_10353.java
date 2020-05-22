import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class GradientHeader {
   private static void createAndShowGui() {
      JTable table1 = new JTable();
      GradientTableHeader gradientTableHeader = new GradientTableHeader();
      gradientTableHeader.setColumnModel(table1.getColumnModel());
      table1.setTableHeader(gradientTableHeader);

      DefaultTableModel model = new DefaultTableModel(new Integer[][] {
            { 1, 2 }, { 3, 4 } }, new String[] { "A", "B" });

      table1.setModel(model);

      JTable table2 = new JTable(model);
      table2.getTableHeader().setDefaultRenderer(new MyCellRenderer());

      JPanel mainPanel = new JPanel(new GridLayout(1, 0));
      mainPanel.add(new JScrollPane(table1));
      mainPanel.add(new JScrollPane(table2));

      JFrame frame = new JFrame("GradientHeader");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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

class GradientTableHeader extends JTableHeader {
   private static final Color COLOR_1 = new Color(255, 0, 0, 240);
   private static final Color COLOR_2 = new Color(0, 0, 255, 120);
   private static final float SIDE = 50;
   private GradientPaint gradientPaint = new GradientPaint(0, 0, COLOR_1, SIDE,
         SIDE, COLOR_2, true);

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setPaint(gradientPaint);
      g2.fillRect(0, 0, getWidth(), getHeight());
   }
}

class MyCellRenderer extends JPanel implements TableCellRenderer {
   private static final Color COLOR_1 = new Color(255, 0, 0, 200);
   private static final Color COLOR_2 = new Color(0, 0, 255, 200);
   private static final float SIDE = 50;
   private GradientPaint gradientPaint = new GradientPaint(0, 0, COLOR_1, SIDE,
         SIDE, COLOR_2, true);
   private JLabel label = new JLabel();

   public MyCellRenderer() {
      setOpaque(true);
      setLayout(new BorderLayout());
      add(label, BorderLayout.CENTER);
      label.setHorizontalAlignment(SwingConstants.CENTER);
   }

   @Override
   public Component getTableCellRendererComponent(JTable table, Object value,
         boolean isSelected, boolean hasFocused, int arg4, int arg5) {
      label.setText(value.toString());
      return this;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setPaint(gradientPaint);
      g2.fillRect(0, 0, getWidth(), getHeight());
   }
}