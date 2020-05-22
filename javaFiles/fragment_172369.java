int a = 0;
int b = 1;
Car[] carArray = new Car[b];

private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
    carArray[a] = new Car (txtfBrand.getText(), txtfYear.getText());
    a++;
    b++;
}