import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class NumberConverterWithCardLayout extends JPanel {
   private CardLayout cardlayout = new CardLayout();
   private JPanel cardPanel = new JPanel(cardlayout);
   private BinaryPanel binaryPanel = new BinaryPanel();
   private OctalPanel octalPanel = new OctalPanel();
   private HexadecimalPanel hexadecimalPanel = new HexadecimalPanel();
   private DecimalPanel decimalPanel = new DecimalPanel();
   private JPanel[] allPanels = { binaryPanel, octalPanel, hexadecimalPanel,
         decimalPanel };

   public NumberConverterWithCardLayout() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));

      setLayout(new BorderLayout());
      add(cardPanel, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.PAGE_END);

      cardPanel.add(createIntroPanel(), "intro");

      for (final JPanel jPanel : allPanels) {
         cardPanel.add(jPanel, jPanel.getName());
         buttonPanel.add(new JButton(new AbstractAction(jPanel.getName()) {

            @Override
            public void actionPerformed(ActionEvent evt) {
               cardlayout.show(cardPanel, jPanel.getName());
            }
         }));
      }
   }

   private JPanel createIntroPanel() {
      JPanel introPanel = new JPanel(new GridBagLayout());
      introPanel.add(new JLabel("Introductory panel which introduces me and the program"));
      return introPanel;
   }

   private static void createAndShowGui() {
      NumberConverterWithCardLayout mainPanel = new NumberConverterWithCardLayout();

      JFrame frame = new JFrame("Number Converter Application");
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

class BinaryPanel extends JPanel {
   public static final String NAME = "Binary";
   private static final int PREF_W = 500;
   private static final int PREF_H = 400;

   public BinaryPanel() {
      setName(NAME);
      add(new JLabel("A complex GUI that does binary calculations will go here"));
   }

   @Override
   // just to give it some size
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}

class OctalPanel extends JPanel {
   public static final String NAME = "Octal";

   public OctalPanel() {
      setName(NAME);
      add(new JLabel("A GUI that does octal calculations will go here"));
   }

}

class HexadecimalPanel extends JPanel {
   public static final String NAME = "Hexadecimal";

   public HexadecimalPanel() {
      setName(NAME);
      add(new JLabel("A GUI that does hexadecimal calculations will go here"));
   }
}

class DecimalPanel extends JPanel {
   public static final String NAME = "Decimal";

   public DecimalPanel() {
      setName(NAME);
      add(new JLabel("A GUI that does decimal calculations will go here"));
   }

}