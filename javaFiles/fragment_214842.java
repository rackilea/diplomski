public BooleanBinding isEitherFieldEmpty() { //This is for the "SUBMIT binding" to check if all text fields are empty
        return txtFirstName.textProperty().isEmpty()
        .or(txtSurname.textProperty().isEmpty())
        .or(txtPNumber.textProperty().isEmpty())
        .or(txtEmail.textProperty().isEmpty())
        .or(date.valueProperty().isNull());
}