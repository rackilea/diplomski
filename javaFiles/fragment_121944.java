validatePassword.setOnFailed(eee->{ // if it fails (that will be indicated by the returned alert message)
    System.out.println("Failed");
    validatePassword.getException().printStackTrace();
    try {
        root.getChildren().remove(pb); // remove it anyway but inform your user
        Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Password", ButtonType.OK);
        alert.showAndWait();
    } catch (Exception e1) {
        e1.printStackTrace();
    }
});