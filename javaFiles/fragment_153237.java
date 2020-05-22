String response = JOptionPane.showInputDialog(myJframe, "Please enter your       Customer Card Code to view your Account Information");
while ( (response==null) || (response.equals("")) )    // if user typed nothing or pressed CANCEL button
{
    JOptionPane.showMessageDialog(myJframe, "You must enter a Customer Card Code!!!", "Error", JOptionPane.ERROR_MESSAGE);     // display error message
    response = JOptionPane.showInputDialog(myJframe, "Please enter your Customer Card Code to view your Account Information"); // ask again for the code until input is correct
}