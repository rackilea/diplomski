import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class SimpleFrame extends JFrame {
   ArrayList<JPanel> panels = new ArrayList<JPanel>();

   public SimpleFrame() {
      super("Simple Panel List Example");

      JPanel content = (JPanel)getContentPane();
      content.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

      // add some panels to the array list
      for(int i = 0; i < 5; i++) {
         BorderLayout b = new BorderLayout();
         JPanel p = new JPanel(b);
         JLabel north = new JLabel("Label #"+i);
         JTextArea center = new JTextArea("TextArea #"+i);
         p.add("North", north);
         p.add("Center", center);

         panels.add(p);
         content.add(p);
      }
   }

   // change the font size of the JTextArea on panel #i
   public void setFontSize(int i, int fontSize) {
      JPanel p = panels.get(i);
      JTextArea t = (JTextArea)((BorderLayout)p.getLayout()).getLayoutComponent("Center");
      Font f = t.getFont();
      Font f2 = f.deriveFont((float)fontSize);
      t.setFont(f2);
   }

   public static void main(String[] argv) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            SimpleFrame c = new SimpleFrame();
            c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            c.pack();
            c.setVisible(true);

            // we can change the font size using our setFontSize method
            c.setFontSize(1, 8);
            c.setFontSize(3, 16);
         }
      });
   }
}