roles1[i].addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

       // get the current selection
       JComboBox currentBox = (JComboBox)e.getSource();
       String currentSelection = (String)currentBox.getSelectedItem();

       // call the method and hand in your current selection
       checkForSelectionExceeding(currentSelection);            

    }
});