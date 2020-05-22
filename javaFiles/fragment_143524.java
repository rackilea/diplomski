private void ReceiptActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String query= "INSERT INTO Sales (Pro_Id ,Pro_Name,Sales_Quantity,Pro_Price ) SELECT Pro_Id,Pro_Name,Sales_Quantity ,Pro_Price FROM Receipt";
    executeSQLQuery(query,"Inserted");
  String qquery= " UPDATE Products SET Pro_Quantity= Products.Pro_Quantity - Receipt.Sales_Quantity FROM Products INNER JOIN Receipt ON Products.Pro_Id = Receipt.Pro_Id" ; 
       executeSQLQuery(qquery,"updated");
    }