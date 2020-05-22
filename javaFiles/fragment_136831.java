//If Username exist
    if (myDb.Exists(email.getText().toString())) {
        showMessage("Error :(","This username is already exists.");
        return;

   }