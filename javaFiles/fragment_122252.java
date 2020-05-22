import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddTableToScroll {
   public static void main(String[] args) {
      final JScrollPane sPane = new JScrollPane();

      // Sorry Jeanette!!
      sPane.setPreferredSize(new Dimension(200, 150));

      JButton button = new JButton(new AbstractAction("Press Me!") {

         public void actionPerformed(ActionEvent arg0) {
            DefaultTableModel model = new DefaultTableModel(new Integer[][] {
                  { 1, 2 }, { 3, 4 } }, new String[] { "A", "B" });
            JTable table = new JTable(model);

            sPane.getViewport().add(table);

         }
      });

      JPanel panel = new JPanel();
      panel.add(sPane);
      panel.add(button);

      JOptionPane.showMessageDialog(null, panel);

   }
}