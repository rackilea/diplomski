btnPlaySci.addActionListener(new PlaySciHandler(panel)); //replace your addActionListener line with this code.

import java.awt.event.*;
class PlaySciHandler implements ActionListener 
{
    JPanel panel;
    PlaySciHandler(JPanel p)
    {
         panel = p;
    }
    public void actionPerformed(ActionEvent ae)   
    {
      ImageIcon rock1 = new ImageIcon("rock.jpg");
      JLabel picture = new JLabel(rock1);
      picture.setBounds(60, 200, 400, 400);
      panel.add(picture);   
    } 
}