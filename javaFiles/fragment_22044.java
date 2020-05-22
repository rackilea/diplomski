import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class Template2 extends JPanel {
   private static final int PREF_W = 1460;
   private static final int PREF_H = 690;
   private BufferedImage img;
   private JButton startButton = new JButton("Start");

   public Template2() {
      setLayout(new GridBagLayout());

      // TODO: .... read in your image here

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.insets = new Insets(5, 10, 0, 0);
      gbc.anchor = GridBagConstraints.NORTHWEST;
      gbc.fill = GridBagConstraints.NONE;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      add(startButton, gbc);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   public void paintComponents(Graphics g) {
      super.paintComponents(g);
      if (img != null) {
         g.drawImage(img, 0, 0, this);
      }
   }

   private static void createAndShowGui() {
      Template2 mainPanel = new Template2();

      JFrame frame = new JFrame("Some Horrendous Program");
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