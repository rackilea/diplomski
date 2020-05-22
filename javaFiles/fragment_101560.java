AddInventory addInv = new AddInventory();

if(inv.getActionCommand().equals("SAVE")){
    invName = addInv.areaName.getText();                
    JOptionPane.showMessageDialog(null, invName);
}