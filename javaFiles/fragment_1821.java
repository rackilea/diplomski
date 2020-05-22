class Calculator extends JFrame implements ActionListener{
   JTextfield firstN, secondN;
   JButton addButton, subButton, divButton, mulButton, enter;
   JLabel result;
   int value;
   Calculator(){
      // here I initialized all the components and added buttons/ActionListeners
   }

   public void actionPerformed(ActionEvent e) {
      int first = Integer.parseInt(firstN.getText());
      int second = Integer.parseInt(secondN.getText());


      if(e.getSource() == addButton){
          value = first + second;
      }else  if(e.getSource() == subButton){
          value = first - second;
      }else if(e.getSource() == divButton){
          value = first/second;
      }else if (e.getSource() == mulButton){
          value = first*second;
      }else if(e.getSource() == enter)
         result.setText(value + "");
      }
  }