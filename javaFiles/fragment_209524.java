//Clears JTextFields before checking the error message
fnameField.setText("");
...

//check how many hours worked to make sure they are within range
if(hoursWorked >= 0 && hoursWorked <=60)
    hours = hoursWorked;

//Display message if hours are not within range
else
    JOptionPane.showMessageDialog(null, "error msg.\n", JOptionPane.ERROR_MESSAGE);
    return