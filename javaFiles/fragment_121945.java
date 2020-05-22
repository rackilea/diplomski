test.setOnAction(e->{
    Platform.runLater(() -> {
        root.getChildren().add(pb);
    });

    Task<Boolean> validatePassword = new Task<Boolean>(){
        @Override
        protected Boolean call() throws Exception {
            return checkLogin();
        }
    };

    validatePassword.setOnSucceeded(ee->{ // when it finishes successfully
        // this cannot throw an exception, there is no need for a try-catch;
        root.getChildren().remove(pb); // remove the progress bar

        if (validatePassword.getValue()) {
            User = dbHandler.getPersonByUsername(username.getText()); // Set up global variable
            Role = dbHandler.getPersonRole(User.getEmail());
            MainStage = (Stage) anchorPane.getScene().getWindow();
            Parent parent = null;
            try {
                parent = FXMLLoader.load(getClass().getResource("/menu.fxml"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Scene scene = new Scene(parent);
            MainStage.setScene(scene);
            MainStage.setTitle("Menu | Administration of Musical Courses");
            MainStage.show();
        } else {
            // handle failed login... this is on the FX Application Thread so 
            // you can show an Alert...
            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Password", ButtonType.OK);
            alert.show();
        }
    });

    validatePassword.setOnFailed(eee->{ 
        // exception was thrown trying to validate password
        validatePassword.getException().printStackTrace();
        // inform user something went wrong...
        Alert alert = new Alert(Alert.AlertType.ERROR, "Something went wrong", ButtonType.OK);
        alert.show();
    });

    new Thread(validatePassword).start(); // add the task to a thread and start it
});