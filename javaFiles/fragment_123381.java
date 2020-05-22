private void findActionPerformed(java.awt.event.ActionEvent evt) {                                     

    try {
        String num = JOptionPane.showInputDialog("Number to Search:");
        if(num != null)
        { 
            int number = Integer.parseInt(num);
            s.search(number);
        }
    }catch (Exception e) {
        JOptionPane.showMessageDialog(this, "WRONG INPUT: you must insert integers", "Erorr", JOptionPane.ERROR_MESSAGE);
    } 
}