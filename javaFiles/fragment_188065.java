void boxItemSelected(ItemEvent e){

    //Create an iterator to iterate over the boxes 
    Iterator<JComboBox<?>> iterator = boxes.iterator();

    while(iterator.hasNext()){

        //Get the current instance of comboBox from the list
        JComboBox<?> current = iterator.next();

        //If the box in which the select or de-select 
        //event has occurred is the current comboBox then do nothing.
        if(e.getSource().equals(current)(
            continue;
        }

        //If the event is select then remove the Item from the 
        //current comboBox else add the Item to the current comboBox.
        if(e.getStateChange() == ItemEvent.SELECTED){
            current.removeItem(e.getItem());
        }else{
            current.addItem(e.getItem());
        }
    }
}