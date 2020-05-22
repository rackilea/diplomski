import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class RandomImages extends JPanel {
   private static final int LABEL_COUNT = 3;
   private Random random = new Random();

   public RandomImages() {
      setLayout(new GridLayout(1, 3));
      for (int i = 0; i < LABEL_COUNT; i++) {
         final List<Icon> iconList = new ArrayList<>();

         // TODO: get images for the ith list 
         // and fill iconList with ImageIcons from the first grouping

         // create JLabel and give it the first Icon from the List above
         final JLabel label = new JLabel(iconList.get(0));
         label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               // get random number from random object using iconList.size()
               // get random Icon from list
               // set label's icon via setIcon(...)
            }
         });
         // add to GUI
         add(label);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("RandomImages");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new RandomImages());
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