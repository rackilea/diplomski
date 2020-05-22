import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Example2 extends JPanel {
   public static final String[] COMBO_TEXTS = {"", "a", "b"};
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private DefaultComboBoxModel<String > comboModel = new DefaultComboBoxModel<>(COMBO_TEXTS);
   private CardLayout cardLayout = new CardLayout();

   public Example2() {
      setLayout(cardLayout);
      ComboListener comboListener = new ComboListener();

      JComboBox<String> combo = new JComboBox<>(comboModel);
      combo.addActionListener(comboListener);;
      JPanel panelBlank = new JPanel();
      panelBlank.add(combo);

      JPanel panelWithText = new JPanel();
      combo = new JComboBox<>(comboModel);
      combo.addActionListener(comboListener);;
      panelWithText = new JPanel();
      panelWithText.add(combo);
      panelWithText.add(new JLabel("Text"));

      JPanel panelWithButton = new JPanel();
      combo = new JComboBox<>(comboModel);
      combo.addActionListener(comboListener);;
      panelWithButton = new JPanel();
      panelWithButton.add(combo);
      panelWithButton.add(new JButton("Hello"));

      add(panelBlank, COMBO_TEXTS[0]);
      add(panelWithText, COMBO_TEXTS[1]);
      add(panelWithButton, COMBO_TEXTS[2]);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class ComboListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         JComboBox<String> combo = (JComboBox<String>)e.getSource();
         String item = combo.getSelectedItem().toString();
         cardLayout.show(Example2.this, item);
      }
   }

   private static void createAndShowGui() {
      Example2 mainPanel = new Example2();

      JFrame frame = new JFrame("Example2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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