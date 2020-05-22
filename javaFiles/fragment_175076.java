public CellTextFieldClear(){
    ...

    textbox.editableProperty().bind(editableProperty());
    textbox.textProperty().bind(textFromTextBoxProperty());
    label.textProperty().bind(labelTextProperty());
}