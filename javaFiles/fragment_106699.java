while(serResult.next()){
   noofbooks++;  
   textResultTitle.setText(serResult.getString("BookTitle"));                       
   textResultISBN.setText(Integer.toString((serResult.getInt("ISBN"))));                           
   textResultPrice.setText(Integer.toString((serResult.getInt("Price"))));
   textAvailability.setText(serResult.getString("IsAvailable"));
}
if (noofbooks == 0){
    JOptionPane.showMessageDialog(null,"Adjust the title");
}