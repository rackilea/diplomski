import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiFrame {

   private static final String FIRST_PANEL = "First Panel";
   private static final String SECOND_PANEL = "Second Panel";
   final JFrame f = new JFrame("Test");
   private CardLayout cardLayout = new CardLayout();
   private JPanel content;

   public void Starter() {
      f.setSize(400, 100);
      f.setLocationRelativeTo(null);
      JButton OptionOk = new JButton("OK");

      Label option = new Label("Choose a Option");

      content = (JPanel) f.getContentPane();
      content.setLayout(cardLayout);

      JPanel firstPanel = new JPanel();
      firstPanel.setBackground(Color.white);
      firstPanel.setLayout(new FlowLayout());

      firstPanel.add(option);
      firstPanel.add(OptionOk);

      content.add(firstPanel, FIRST_PANEL);
      content.add(createSecondPanel(), SECOND_PANEL);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      OptionOk.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            cardLayout.show(content, SECOND_PANEL);

         }
      });

   }

   private JPanel createSecondPanel() {
      JPanel secondPanel = new JPanel();
      secondPanel.add(new JButton(new AbstractAction("Go Back") {
         public void actionPerformed(ActionEvent e) {
            cardLayout.show(content, FIRST_PANEL);
         }
      }));
      return secondPanel;
   }


   public static void main(String[] args) {

      GuiFrame gf = new GuiFrame();
      gf.Starter();
   }

}