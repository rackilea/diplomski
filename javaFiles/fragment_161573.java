try
{
    salary = Double.parseDouble(salaryTextField.getText());
    restaurant.getEmployees().add(new Cook(id, name, salary));
    id++;
    JOptionPane cookOptionPane = new JOptionPane();
    JOptionPane.showMessageDialog(cookOptionPane, "Cook added succesfully.");
}
catch(NumberFormatException ex)
{
    JOptionPane cookFailPane = new JOptionPane();
    JOptionPane.showMessageDialog(cookFailPane , "Could not add cook. Please enter salary using only numeric input.");
    ex.printStackTrace();
}