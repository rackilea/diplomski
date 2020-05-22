tc.setCellFactory(column - > {
   return new TableCell < TableListObject, String > () {
     protected void updateItem(String item, boolean empty) {
       super.updateItem(item, empty);

       if (item == null || empty) {
         setText(null);
         setStyle("");
       } else {
         int rowIndex = getTableRow().getIndex();
         String valueInSecondaryCell = getTableView().getItems().get(rowIndex).getMethod();
         if (valueInSecondaryCell.equals("Something Else")) {
           setStyle("-fx-background-color: yellow"); //Set the style in the first cell based on the value of the second cell
         } else {
           setStyle("");
         }

       }
     }
   };
 });