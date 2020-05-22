int dialogButton= JOptionPane.YES_NO_CANCEL_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(null, "Your Message", "Dialog box title",dialogButton);
if(dialogResult==JOptionPane.YES_OPTION){
//Code for YES Button Clicked
}
else if(dialogResult==JOptionPane.NO_OPTION)
{
//Code for NO Button Clicked
}
else if(dialogResult==JOptionPane.CANCEL_OPTION){
//Code for CANCEL Button Clicked
}