import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Swapper {
   private static final String BLUEPRINT = "http://duke.kenai.com/IPG/Duke_Blueprint.gif";
   private static final String COOKIES = "http://duke.kenai.com/IPG/Duke_Cookies.gif";
   private static final String INT_FLOAT_CHAR = "http://duke.kenai.com/IPG/Duke_Int_Float_Char.gif";
   private static final String THREAD = "http://duke.kenai.com/IPG/Duke_Thread.gif";

   private JPanel mainPanel = new JPanel();
   private JMenu menu = new JMenu("Menu");
   private JMenuBar menuBar = new JMenuBar();
   private CardLayout cardlayout = new CardLayout();

   public Swapper() {
      mainPanel.setLayout(cardlayout);
      mainPanel.setBackground(Color.white);
      addCard("Blueprint", BLUEPRINT);
      addCard("Cookies", COOKIES);
      addCard("Int Float Char", INT_FLOAT_CHAR);
      addCard("Thread", THREAD);

      menuBar.add(menu);
   }

   private void addCard(String name, String imagePath) {
      BufferedImage img;
      try {
         URL imgUrl = new URL(imagePath);
         img = ImageIO.read(imgUrl);
         ImageIcon icon = new ImageIcon(img);
         JLabel label = new JLabel(icon);
         mainPanel.add(label, name);
         menu.add(new JMenuItem(new MenuAction(name)));

      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   public JMenuBar getMenuBar() {
      return menuBar;
   }

   private class MenuAction extends AbstractAction {

      public MenuAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent arg0) {
         String name = getValue(NAME).toString();
         cardlayout.show(mainPanel, name);
      }
   }

   private static void createAndShowGui() {
      Swapper swapper = new Swapper();

      JFrame frame = new JFrame("Swapper");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(swapper.getMainPanel());
      frame.setJMenuBar(swapper.getMenuBar());
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