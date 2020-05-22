// Adding focus listener to textBox to wait for loss of focus to perform SQL statement.
 FocusAdapter focusTextBox = new FocusAdapter() 
 {
  @Override
  public void focusLost(FocusEvent evt) 
  {
   // Get the contents of otherTextBox and textBox. (otherTextBox must be <= textBox)
   String boxFour = otherTextBox.getText();
   String boxFive = textBox.getText();

   // If either text box has spaces in it, don't perform the search.
   if (boxFour.contains(" ") || boxFive.contains(" "))
   {
       // Don't perform SQL statements.  Debug statement.
       System.out.println("Tray Position input contains spaces.  Ignoring.");

                //Make all previous results invisible, if any.
                labels.setVisible(false);
                differentTextBox.setText("");
                labelResults.setVisible(false);
   }
   else
   {
             //... Perform SQL statement ...
            }
  }
 };