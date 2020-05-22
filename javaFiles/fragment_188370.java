int empid; 
try {
    empid = Integer.parseInt(jtfEid.getText().trim());
} catch(NumberFormatException nfe) {
    JOptionPane.showMessageDialog(null, "Please Enter Your Id");
}