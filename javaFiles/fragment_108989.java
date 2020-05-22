if (courseNum == 103)
  {
     JOptionPane.showMessageDialog(null,message1);
  }                  
  else if (courseNum == 206)
  {
     JOptionPane.showMessageDialog(null,message4);
  }      
  else if (courseNum == 106)
  {
     answer = JOptionPane.showInputDialog("Have you passed IT 102?");
     if (answer.equals("yes"))
     {
        JOptionPane.showMessageDialog(null,message2);
     }
     else if (answer.equals("no"))
     {
        JOptionPane.showMessageDialog(null,message3);
     }
  }
  else
  {
     JOptionPane.showMessageDialog(null,message5);
  }