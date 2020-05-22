import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

@SuppressWarnings("serial")
public class LayoutFoo2 extends JPanel {

   private static final Insets DEFAULT_INSETS = new Insets(5, 5, 5, 5);
   private static final double DEFAULT_WEIGHTX = 1.0;
   private static final double DEFAULT_WEIGHTY = 1.0;
   private static JFrame vframe;
   private static JPanel vpanel;
   private static JLabel titlelabel;
   private static JLabel namelabel;
   private static JTextField namefield;
   private static JLabel birthdaylabel;
   private static JLabel dayDD;
   private static String[] daysArray;
   private static JComboBox BDday;
   private static JLabel monthDD;
   private static String[] monthsArray;
   private static JComboBox BDmonth;
   private static GridBagConstraints grid;

   public static void main(String[] args) {
      vframe = new JFrame("MES Banking App");
      vpanel = new JPanel();
      titlelabel = new JLabel("Verification Page");
      namelabel = new JLabel("Name: ");
      namefield = new JTextField(20);
      birthdaylabel = new JLabel("Birth date: ");
      dayDD = new JLabel("Day:");
      daysArray = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "11", "12", "13", "14", "15", "16", "17", "18" };// 31
      BDday = new JComboBox(daysArray);
      monthDD = new JLabel("Month:");
      monthsArray = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "11", "12" }; // 12 months
      BDmonth = new JComboBox(monthsArray);

      // title section
      vpanel.setLayout(new GridBagLayout());
      grid = createGbc(0, 0, 5, 1);
      grid.fill = GridBagConstraints.CENTER;
      titlelabel.setHorizontalTextPosition(JLabel.CENTER);
      vpanel.add(titlelabel, grid);

      // name section
      grid = createGbc(0, 1);
      vpanel.add(namelabel, grid);// adds name label

      grid = createGbc(1, 1, 4, 1);
      vpanel.add(namefield, grid); // adds name text field

      // birthday section
      grid = createGbc(0, 2);
      vpanel.add(birthdaylabel, grid); // adds bday label
      grid = createGbc(1, 2);
      vpanel.add(dayDD, grid); // add day label


      grid = createGbc(2, 2);
      vpanel.add(BDday, grid);

      grid = createGbc(3, 2);
      vpanel.add(monthDD, grid);
      grid = createGbc(4, 2);
      vpanel.add(BDmonth, grid);

      vframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      vframe.getContentPane().add(vpanel);

      vframe.pack();
      vframe.setVisible(true);
   }

   public static GridBagConstraints createGbc(int x, int y, int width, int height) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = width;
      gbc.gridheight = height;

      // default set ups
      gbc.insets = DEFAULT_INSETS;
      gbc.weightx = DEFAULT_WEIGHTX;
      gbc.weighty = DEFAULT_WEIGHTY;
      gbc.fill = GridBagConstraints.HORIZONTAL;

      return gbc;
   }

   public static GridBagConstraints createGbc(int x, int y) {
      return createGbc(x, y, 1, 1);
   }
}