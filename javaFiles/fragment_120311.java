import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UglyGui2 {
   private static final String SALE = "Sale";
   private static final String PURCHASE = "Purchase";

   private JMenuItem sub_menu_sale = new JMenuItem(SALE);
   private JMenuItem sub_menu_purchase = new JMenuItem(PURCHASE);
   private CardLayout cardLayout = new CardLayout();
   private JPanel cardPanel = new JPanel(cardLayout);
   private JPanel mainPanel = new JPanel(new BorderLayout(5, 5));

   public UglyGui2() {
      cardPanel.add(new JLabel(), "");
      cardPanel.add(createSalePanel(), SALE);
      cardPanel.add(createPurchasePanel(), PURCHASE);

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      buttonPanel.add(new JButton("Reset"));
      buttonPanel.add(new JButton("Save"));
      buttonPanel.add(new JButton("Print"));
      buttonPanel.add(new JLabel());
      buttonPanel.add(new JButton("Cancel"));

      mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      mainPanel.add(cardPanel, BorderLayout.CENTER);
      mainPanel.add(buttonPanel, BorderLayout.PAGE_END);

   }

   private JComponent createSalePanel() {
      JPanel salePanel = new JPanel(new GridBagLayout());
      salePanel.add(new JLabel("Sales"));
      salePanel.add(new JTextField(10));
      return salePanel;
   }

   private JComponent createPurchasePanel() {
      JPanel topPanel = new JPanel();
      topPanel.add(new JLabel("Purchases"));
      topPanel.add(new JTextField(10));

      JPanel purchasePanel = new JPanel(new BorderLayout());
      purchasePanel.add(topPanel, BorderLayout.PAGE_START);
      purchasePanel.add(new JScrollPane(new JTextArea(30, 60)), BorderLayout.CENTER);
      return purchasePanel;   }

   private Component getMainPanel() {
      return mainPanel;
   }

   private JMenuBar getJMenuBar() {
      ActionListener aListener = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, e.getActionCommand());
         }
      };

      sub_menu_purchase.addActionListener(aListener);
      sub_menu_sale.addActionListener(aListener);

      JMenu menu = new JMenu("Menu");
      menu.add(sub_menu_purchase);
      menu.add(sub_menu_sale);

      JMenuBar menuBar = new JMenuBar();
      menuBar.add(menu);
      return menuBar;
   }

   private static void createAndShowGui() {
      UglyGui2 uglyGui = new UglyGui2();

      JFrame frame = new JFrame("Ugly Gui Example");
      frame.setJMenuBar(uglyGui.getJMenuBar());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(uglyGui.getMainPanel());
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