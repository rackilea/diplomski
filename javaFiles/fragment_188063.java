void boxItemSelected(ItemEvent e){

    //Check the item selected/deselected is "three" else do nothing.
    if (e.getItem().equals("three")){ 

    //Find the box on which this action was not performed to change its model.
        JComboBox<String> oppositeBox;
        if(e.getSource().equals(box1)){
            oppositeBox = box2;
        }else{
            oppositeBox = box1;
        }

    //Check the item is selected or deselected to remove or add "three" to item list.
        if(e.getStateChange() == ItemEvent.SELECTED){
            oppositeBox.removeItem("three");
        }else{
            oppositeBox.addItem("three");
        }
    }
}