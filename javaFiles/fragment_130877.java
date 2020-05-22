import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestHandCursor extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = 300;

   // the cardlayout:
   private CardLayout cardLayout = new CardLayout();

   // the cardlayout using JPanel
   private JPanel cardHolderPanel = new JPanel(cardLayout);

   // the action that a button uses to swap cards
   private SwapCardAction swapCardAction = new SwapCardAction("Swap View");
   private JButton swapButton = new JButton(swapCardAction);

   public TestHandCursor() {
      // set up button's cursor
      swapButton.setFocusPainted(false);
      swapButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

      // dummy JPanels to add to the CardLayout-using JPanel
      JPanel panel1 = new JPanel();
      panel1.add(new JLabel("Panel 1"));
      panel1.add(new JButton("Button 1"));

      String[] items = { "Stormy Monday", "Tuesday's Just as Bad",
            "Wednesday's Worse", "Thursday's Oh So Sad" };
      JPanel panel2 = new JPanel();
      panel2.add(new JLabel("Panel 2"));
      panel2.add(new JComboBox<String>(items));

      JPanel panel3 = new JPanel();
      panel3.add(new JLabel("Panel 3"));

      // add above JPanels to the cardHolderPanel:
      cardHolderPanel.add(panel1, "panel 1");
      cardHolderPanel.add(panel2, "panel 2");
      cardHolderPanel.add(panel3, "panel 3");

      // panel to hold JButton
      JPanel bottomPanel = new JPanel();
      bottomPanel.add(swapButton);

      // add all to the main JPanel
      setLayout(new BorderLayout());
      add(cardHolderPanel, BorderLayout.CENTER);
      add(bottomPanel, BorderLayout.PAGE_END);
   }

   // let's make our GUI a little bigger
   @Override
   public Dimension getPreferredSize() {
      Dimension superSize = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSize;
      }

      int prefW = Math.max(superSize.width, PREF_W);
      int prefH = Math.max(superSize.height, PREF_H);
      return new Dimension(prefW, prefH);
   }

   // button Action to swap "cards" in our CardLayout
   private class SwapCardAction extends AbstractAction {
      public SwapCardAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         cardLayout.next(cardHolderPanel);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("TestHandCursor");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TestHandCursor());
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