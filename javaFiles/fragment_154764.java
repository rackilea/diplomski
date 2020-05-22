import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Odometer extends JPanel{
   private JLabel label, label2, label3;
   private int counter;
   public Odometer()
   {
      setLayout(new FlowLayout());

      JButton button = new JButton("Step");
      button.addActionListener(new Listener());
      add(button);

      this.setBackground(Color.black);

      label = new JLabel("0");
      label.setFont(new Font("serif", Font.BOLD, 50));
      label.setForeground(Color.white);
      label.setBackground(Color.black);
      label.setOpaque(true);
      add(label);

      label2 = new JLabel("0");
      label2.setFont(new Font("serif", Font.BOLD, 50));
      label2.setForeground(Color.white);
      label2.setBackground(Color.black);
      label2.setOpaque(true);
      add(label2);

      label3 = new JLabel("0");
      label3.setFont(new Font("serif", Font.BOLD, 50));
      label3.setBackground(Color.white);
      label3.setForeground(Color.black);
      label3.setOpaque(true);
      add(label3);

   }


   private class Listener implements ActionListener{
      public void actionPerformed(ActionEvent e){
          update();

      }

   }


   public void update()
   {

      counter = Integer.parseInt(label3.getText());
      if(counter < 9){
          System.out.println("increment");
         counter++;
         label3.setText("" + counter);

      }

      else{ //When the one's is greater than 9
         counter = 0;
         label3.setText("" + counter);
         counter = Integer.parseInt(label2.getText());


         if(counter < 9){ 
            counter++;
            label2.setText("" + counter);

         }
         else{ //When the 10's place is greater than 9
            counter = 0;
            label2.setText("" + counter);
            counter = Integer.parseInt(label.getText());

         if(counter<9){
            counter++;
            label.setText("" + counter);
         }
         else{ 
            counter = 0;
            label.setText("0");
            }
         }
      }


   }
}