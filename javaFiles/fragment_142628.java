// Your desired Accuracy choices for dialog combox.
Object[] possibilities = {"20%", "80%", "100%"};

//The panel to display within the Dialog
JPanel jp = new JPanel();
jp.setLayout(new BorderLayout());   // Panel layout manager

// JLabel to hold the dialog text. HTML is used to add pizzaz. :)
JLabel jl = new JLabel(
        "<html>Select the desired <font color=blue><b>Accuracy Level</font>:"
        + "</b><br><br></html>");  
// Desired font, style, and size for Message
Font font = new Font("Arial", Font.PLAIN, 14); 
jl.setFont(font);    // Set the font to JLabel (the msg)
jp.add(jl, BorderLayout.NORTH);     // Add JLabel to top of Dialog

// JComboBox to hold all the available Accuracy choices.
JComboBox jc = new JComboBox(possibilities);
jc.setSelectedIndex(2);  // Set 100% as default in Combo
// Desired font, style, and size for combo items
font = new Font("Arial", Font.PLAIN, 20); 
jc.setFont(font);   // Set the font to combo
jp.add(jc, BorderLayout.SOUTH);      // Add JComboBox to Bottom section of Dialog

String valueSelected;  // Variable to hold the combo selected value.

/* Display the custom Input Box Dialog which is actually a
   customized Confirm Dialog Box with the above JPanel supplied
   as the message content.  Also, if the OK button was selected
   then fill the valueSelected string variable declared above 
   with the Combo selection. 100% has been set as default.*/
if (JOptionPane.showConfirmDialog(this, jp, "Accuracy", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)  == 0) {
    valueSelected = jc.getSelectedItem().toString();
    System.out.println("Accuracy Selected Is: " + valueSelected);
}
else {
    System.out.println("Input Canceled");
}