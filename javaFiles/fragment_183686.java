if (p1.getPassword().length == 0 || p2.getPassword().length == 0){                 
    JOptionPane.showMessageDialog(null, "Passwords fields can not be empty.", "Woops", JOptionPane.ERROR_MESSAGE);
}

else if (!Arrays.equals(p1.getPassword(), p2.getPassword())) {
    JOptionPane.showMessageDialog(null, "Passwords do not match.", "Woops", JOptionPane.ERROR_MESSAGE);
}

else {    
    JOptionPane.showMessageDialog(null, "Registered Successfully", "Login Warning", JOptionPane.WARNING_MESSAGE);
}