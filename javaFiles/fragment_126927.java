Node lastFocusedNode =null; // lastly known node to have focus
//now every node or child in your ScrollPane or Scrollable parent 
//that you care about will have a focusable listener-including
// your textfield
textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
@Override
public void changed(
        ObservableValue<? extends Boolean> observable,
                Boolean oldValue, Boolean newValue) {
                if(!newValue){//if they loose focus
                    lastFocusedNode = textField;
                    //if they loose focus attach them to lastFocusedNode
                }
            }
        });
 //the above saves you iterations