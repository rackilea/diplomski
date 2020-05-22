import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColorBackground {
   private static final int PREF_W = 600;
   private static final int PREF_H = 450;

   // my main JPanel. I declare it in the class
   private JPanel mainPanel = new JPanel() {
      public Dimension getPreferredSize() {
         // so kleopatra doesn't down-vote me
         return ColorBackground.this.getPreferredSize();
      };
   };
   private JComboBox colorBox = new JComboBox(ColorChoices.values());

   public ColorBackground() {
      mainPanel.add(colorBox);

      colorBox.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            ColorChoices choice = (ColorChoices) colorBox.getSelectedItem();
            mainPanel.setBackground(choice.getColor()); // now I can call methods on the field
         }
      });
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Color Background");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ColorBackground().getMainPanel());
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

enum ColorChoices {
   DEFAULT("Default", null), ORANGE("Orange", Color.orange), BLUE("Blue",
         Color.blue), HOT_PINK("Hot Pink", new Color(255, 64, 128));

   public String getName() {
      return name;
   }

   @Override
   public String toString() {
      return name;
   }

   public Color getColor() {
      return color;
   }

   private ColorChoices(String name, Color color) {
      this.name = name;
      this.color = color;
   }

   private String name;
   private Color color;
}