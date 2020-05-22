/**
* Check if all the TextFields are filled and not empty
* @param table
*/
 private static boolean isAllFilled(GridPane table){
    for(Node node : table.getChildren()){ // cycle through every component in the table (GridPane)
        if(node instanceof TextField){ // if it's a TextField
        // after removing the leading spaces, check if it's empty
            if(((TextField)node).getText().trim().isEmpty()){
                    return false; // if so, return false
            }
        }       
    }
    return true;
 }