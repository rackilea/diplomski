add(text);
        text.setVisible(false);
        //this.add(pnlButton);
        pnlButton.setLayout(null); // setting the null layout to the button panel
        pnlButton.add(b);      
        //pnlButton.setVisible(true); // why do you need it ? it is already true
        //pnlButton.setLocation(800,800);  // weired location, remove it 
        //b.setVisible(true);    // why do you need it? it is already true
        //b.setPreferredSize(new Dimension(150,40));
         b.setBounds(20, 20, 100, 30); // putting setBounds here
        b.addActionListener(this);

         setContentPane(pnlButton);   //set the pnlButton as content pan

    }