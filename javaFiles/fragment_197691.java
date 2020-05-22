import static javafx.beans.binding.Bindings.*;

BooleanBinding notComplete = or(
  equal(textFieldDialogUserID.textProperty(), null),
  equal(passwordFieldDialogPassword.textProperty(), null));

Node createButton = signUpDialog.getDialogPane().lookupButton(buttonTypeCreate);
createButton.disableProperty().bind(notComplete);