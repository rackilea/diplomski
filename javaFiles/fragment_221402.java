//Method to change the text of the JRadion Buttons, what i'm trying to make work
     ActionListener al = new ActionListener() {

        public void actionPerformed(ActionEvent e) {

             if(b1.isSelected()){
                    b1.setText("Welcome");
                }
                else if(b2.isSelected()){
                    b2.setText("Hello");
                }
        }
      };

b1= new JRadioButton("green"); 
b1.addActionListener(al);
b2= new JRadioButton("red"); 
b2.addActionListener(al);