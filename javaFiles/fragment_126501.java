else {
         TableListObject listObject = (TableListObject) getTableRow().getItem();
         if (listObject.getMethod().equals("Something Else")) {
           setStyle("-fx-background-color: yellow"); //Set the style in the first cell based on the value of the second cell
         } else {
           setStyle("");
         }
       }