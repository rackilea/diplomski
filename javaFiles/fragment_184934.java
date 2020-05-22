import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class LayoutFoo2 {

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
      grid = new GridBagConstraints();
      grid.fill = GridBagConstraints.CENTER;
      grid.insets = new Insets(5, 5, 5, 5);
      grid.weightx = 1.0;
      grid.weighty = 1.0;
      grid.fill = GridBagConstraints.HORIZONTAL;
      grid.gridx = 0;
      grid.gridy = 0;
      grid.gridwidth = 5;
      grid.gridheight = 1;
      vpanel.add(titlelabel, grid);

      // name section
      grid.fill = GridBagConstraints.HORIZONTAL;
      grid.gridwidth = 1;
      grid.gridx = 0;
      grid.gridy = 1;
      vpanel.add(namelabel, grid);// adds name label
      grid.gridx = 1;
      grid.gridy = 1;
      grid.gridwidth = 4;
      vpanel.add(namefield, grid); // adds name text field

      // birthday section
      grid.fill = GridBagConstraints.HORIZONTAL;
      grid.gridx = 0;
      grid.gridy = 2;
      grid.gridwidth = 1;
      vpanel.add(birthdaylabel, grid); // adds bday label
      grid.gridx = 1;
      grid.gridy = 2;
      vpanel.add(dayDD, grid); // add day label

      grid.fill = GridBagConstraints.HORIZONTAL;
      grid.gridx = 2;
      grid.gridy = 2;
      //!! grid.insets = new Insets(0, 30, 0, 350);// sets day drop down
      vpanel.add(BDday, grid);

      grid.fill = GridBagConstraints.HORIZONTAL;
      grid.gridx = 3;
      grid.gridy = 2;
      //!! grid.insets = new Insets(0, 100, 0, 250);// month label
      vpanel.add(monthDD, grid);

      grid.fill = GridBagConstraints.HORIZONTAL;
      grid.gridx = 4;
      grid.gridy = 2;
      //!! grid.insets = new Insets(0, 150, 0, 250);
      vpanel.add(BDmonth, grid);

      vframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      vframe.getContentPane().add(vpanel);

      vframe.pack();
      vframe.setVisible(true);
   }
}