private String field1String = "";
 private String field2String = "";

    // you'll need one of these for each text field
    private class TextField1Handler implements ActionListener 
           {
              @Override
              public void actionPerformed(ActionEvent e)
              {
                field1String = yourField1.getText();

              }
           }

      // attach this to your button
      private class ButtonClickHandler implements ActionListener 
           {
              @Override
              public void actionPerformed(ActionEvent e)
              {
                 JOptionPane.showMessageDialog(null, "Your textfields \n" + 
                  field1String + field2String); 

              }
           }