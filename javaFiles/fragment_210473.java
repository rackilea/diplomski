import javax.swing.*;
import java.awt.*;

public class JavaGui extends JFrame {

   public static void main(String[] args) {

      JavaGui window = new JavaGui();

      // setup window here

      // main panels    

      JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel panelLeft = new JPanel(new GridBagLayout());
      JPanel panelRight = new JPanel(new GridBagLayout());
      JPanel centralPanel = new JPanel(new GridLayout(1, 2));
      centralPanel.add(panelLeft);
      centralPanel.add(panelRight);
      window.add(container);
      container.add(centralPanel);

      // grid layout panels

      GridBagConstraints grid = new GridBagConstraints();


      // test labels

      JLabel label01 = new JLabel("Label 01");
      JLabel label02 = new JLabel("Label 02");
      JLabel label03 = new JLabel("Label 03");
      JLabel label04 = new JLabel("Label 04");

      // add labels to grids

      grid.gridx = 0;
      grid.gridy = 0;
      panelLeft.add(label01, grid);
      grid.gridx = 0;
      grid.gridy = 0;
      panelRight.add(label02, grid);
      grid.gridx = 0;
      grid.gridy = 1;
      panelRight.add(label03, grid);
      grid.gridx = 0;
      grid.gridy = 2;
      panelRight.add(label04, grid);

      // add borders to see sizes

      panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
      panelRight.setBorder(BorderFactory.createLineBorder(Color.black));
      window.setVisible(true);
      window.pack();
   };

};