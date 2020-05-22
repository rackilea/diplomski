Button1.addActionListener(new ActionListener() {

   public void actionPerformed(ActionEvent e)
   {
       // get the size of side1 from the textbox
       String t1TextBox = t1.getText();
       double side1 = Double.parseDouble(t1TextBox);

       // get the size of side2 from the textbox
       String t2TextBox = t2.getText();
       double side2 = Double.parseDouble(t2TextBox);

       // now we can calculate the area
       double Area = (side1 * side2)/2;

       //Execute when button is pressed
       System.out.println(Area);
   }