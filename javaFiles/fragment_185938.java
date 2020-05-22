JLabel myLabel = ... // Example JLabel from other part of program
...

class ItemChangeListener implements ItemListener{
    @Override
    public void itemStateChanged(ItemEvent event){ // Fired on selection
        if(event.getStateChange() == ItemEvent.SELECTED){ // Check for selection
            Object item = event.getItem(); // Here is selected item
            String expenseCode = item.toString(); // Get String

            String result = ...; // Use query here - 
                                 // same way as with your other query

            myLabel.setText(result); // Update JLabel with found String
        }
    }       
}