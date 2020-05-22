private void theListValueChanged(ListSelectionEvent e) {
    final Object selectedValue = theList.getSelectedValue();
    if ( selectedValue != null ) {
        txtCameraName.setText( selectedValue.toString() );
    } else {
        // Clear the text since there's no selection
        txtCameraName.setText( null );
    }   
}