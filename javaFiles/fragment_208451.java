private ObservableList < Items > generateInvoiceEntry() { // generate table      with its inputs values
  Items newItems = new Items(); 
  newItems.setProductName(ProductBox.getSelectionModel().getSelectedItem().toString());
  newItems.setSupplierName(SupplierBox.getSelectionModel().getSelectedItem().toString());
  newItems.setBatchNo(Batch.getText());
  newItems.setBonus(this.toInteger(Bonus.getText()));
  newItems.setDiscount(this.toFloat(DiscountPercent.getText()));
  newItems.setQuantity(this.toInteger(Quantity.getText()));
  newItems.setPurchaseRate(this.toFloat(PurchaseRate.getText()));
  list.add(newItems);
  return list;
 }