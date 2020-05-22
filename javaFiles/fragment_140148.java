import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class AddingText extends JPanel {
   private static final int PREF_W = 500;
   private static final int PREF_H = PREF_W;

   public AddingText() {
      addMouseListener(new MyMouse());

      setLayout(null); // one of the few times this may be ok
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private void convertToLabel(final JTextField textField) {
      JLabel label = new JLabel(textField.getText());
      label.setSize(label.getPreferredSize());
      label.setLocation(textField.getLocation());
      remove(textField);
      add(label);
      repaint();
   }

   private class MyMouse extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         final JTextField textField = new JTextField(20);
         textField.setSize(textField.getPreferredSize());
         textField.setLocation(e.getPoint());
         add(textField);         
         revalidate();
         repaint();

         textField.requestFocusInWindow();
         textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
               convertToLabel((JTextField) e.getComponent());
            }
         });
         textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               convertToLabel((JTextField) e.getSource());
            }
         });
      }
   }

   private static void createAndShowGui() {
      AddingText mainPanel = new AddingText();

      JFrame frame = new JFrame("AddingText");
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