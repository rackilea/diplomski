// remove the button:
toolbarForActivityPanel.getItems().remove(createOfActivityButton);
// remove the text field (need to provide an fx:id for the text field in FXML):
toolbarForActivityPanel.getItems().remove(textField);

// add the text field as the first element:
toolbarForActivityPanel.getItems().add(0, textField);
// add the button as the third element:
toolbarForActivityPanel.getItems().add(2, createOfActivityButton);