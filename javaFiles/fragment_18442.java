import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JListFun {
   public static void main(String[] args) {
      final JList<String> list = new JList<String>(new String[]{"one", "two", "three", "four", "five"});
      JScrollPane scrollPane = new JScrollPane(list);
      JButton btn = new JButton(new AbstractAction() {
         {
            putValue(NAME, "Press Me");
         }

         @Override
         public void actionPerformed(ActionEvent evt) {
            list.setSelectedIndex(0);
         }
      });
      JPanel panel = new JPanel();
      panel.add(scrollPane);
      panel.add(btn);
      JOptionPane.showMessageDialog(null, panel);
   }
}