App.getUsers()
   .stream()
   .filter(o -> o.getEmail().equalsIgnoreCase(emailText.getText()))
   .findFirst()
   .ifPresent(declaredUser -> {
        // declaredUser is in scope here!
    });