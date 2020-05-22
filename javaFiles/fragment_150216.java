/**
* To Validate the Table (GridPane)
* This method should be added to the tabPane change listener
* @param table
* @param button
*/
private void validateTable(GridPane table, Button button) {

   for(Node node : table.getChildren()){ // cycle through every component in the table (GridPane)
      if(node instanceof TextField){ // if it's a TextField
        ((TextField)node).textProperty().addListener((obs, old, newV)->{ // add a change listener to every TextField
        // then check if the new value is not empty AND all other TextFields are not empty
          if(!newV.trim().isEmpty()&&isAllFilled(table)){ 
             button.setDisable(false); // then make the button active again
          }
          else{
              button.setDisable(true); // or else, make it disable until it achieves the required condition 
          }
      });
   }    
}