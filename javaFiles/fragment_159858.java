private void modifyActionPerformed(java.awt.event.ActionEvent evt) {                                       
         // TODO add your handling code here:
        System.out.println("HERE");
        String tel = JOptionPane.showInputDialog("Edit phone number");
        NrTel nrtel = new NrTel(Integer.parseInt(tel));
        jTable.getModel().setValueAt(nrtel, 0, 1);
}