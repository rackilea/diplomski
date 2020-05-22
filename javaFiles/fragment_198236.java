private int number = 0;
private void setNumber(int no){
    this.number = no;
}
private Integer getNumber(){
    return this.number;
}
private void addActionPerformed(java.awt.event.ActionEvent evt) {       
    int i = 1;
    int newAddedNumber = this.number + i;
    setNumber(newAddedNumber);
}   
private void substractActionPerformed(java.awt.event.ActionEvent evt) {                                  
    int i = 1;
    int newSubtractedNumber = this.number - i;
    setNumber(newSubstractedNumber);
}
private void equalsActionPerformed(java.awt.event.ActionEvent evt) {
   int displayCurrentNo = getNumber();
   System.out.println("current Number is : "  + displayCurrentNo) 
}