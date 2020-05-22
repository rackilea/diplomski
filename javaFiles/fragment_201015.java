@FXML
    public handleSelectItem(){
       for ( CheckBox box : boxList ) {
          // Unselect all checkboxes, except the one that invoked the method
          if( box.isSelected() && box!=this ){
             box.setSelected(false);
          }
       }
    }