alculateB.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
         double amount, years, interst, certificate;

         amount = Double.parseDouble(amountTF.getText());
         years = Double.parseDouble(yearsTF.getText());
         interest = Double.parseDouble(interestTF.getText());
         certificate = amount * Math.pow(1 + rate/100, years);

         certificateTF.setText("" + certificate);
      }
   });

exitB.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e)
       {
           System.exit(0);
       }
   });