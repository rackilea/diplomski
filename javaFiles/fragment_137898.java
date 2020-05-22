ResultSet resultSet = statement.executeQuery(SQL);
if (resultSet.next()) {
    //No need to re-validate
    Main.applyHomescreenLayout();
} else {
    //no email|password combination found on database
    errorMessage.setText("Incorrect Email.");
        errorMessage.setTextFill(Color.RED);
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000.0), errorMessage);
        fadeTransition.setFromValue(3000.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.playFromStart();
}