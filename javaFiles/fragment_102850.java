int buffer = JOptionPane.showConfirmDialog(rootPane, "Are You Sure You Want to Submit This Data and Genertate a New Remittance Id!")

// user pressed yes
if(buffer == 0) {
    try {
        // whatever
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
}
else if(buffer == 1) {
     // user input = no
}

else if(buffer == 2) {
     // user input = cancel
}