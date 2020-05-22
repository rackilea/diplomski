super.updateItem(item, empty);//does important things in super
        if (empty) {                  //what to do if cell is empty   
            setText(null);
            setDisable(false);        //reset the disabled state 
        } else {
            setText(item.toString()); //calls toString in your custom class
            setDisable(! item.isSelectable()); //what stops you from selecting
            setTextFill(item.isSelectable()
                    ?Color.BLUE:Color.BLACK); //changing the color
        }