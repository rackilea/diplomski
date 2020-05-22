import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class CardLayoutFoo extends JPanel {
   public static final String BAR = "bar";
   public static final String BUTTON_PANEL = "button panel";
   private CardLayout cardlayout = new CardLayout();

   public CardLayoutFoo() {
      setLayout(cardlayout);

      JLabel fooLabel = new JLabel("Foo", SwingConstants.CENTER);
      add(fooLabel, BAR); // added using String constant, BAR

      JButton showFooBtn = new JButton(new AbstractAction("Show Foo") {

         @Override
         public void actionPerformed(ActionEvent evt) {
            // use same String, BAR, to get the fooLabl shown
            cardlayout.show(CardLayoutFoo.this, BAR);
         }
      });
      JPanel btnPanel = new JPanel();
      btnPanel.add(showFooBtn);
      add(btnPanel, BUTTON_PANEL);

      cardlayout.show(this, BUTTON_PANEL);            
   }

   private static void createAndShowGui() {
      CardLayoutFoo mainPanel = new CardLayoutFoo();

      JFrame frame = new JFrame("CardLayoutFoo");
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