private void displayActionPerformed(java.awt.event.ActionEvent evt) { 

    // 1st get the ButtonModel for the selected radio button
    ButtonModel buttonModel = buttonGroup.getSelection();

    // if a selection has been made, then model isn't null
    if (buttonModel != null) {  
        // again actionCommand needs to be set for each JRadioButton
        String actionCommand = buttonModel.getActionCommand();
        // TODO: use actionCommand String as needed
    }
}