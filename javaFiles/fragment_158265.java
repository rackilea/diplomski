final String selection = cityChoiceBox.getValue();
new Thread(() ->  {
    // do this on this thread, not on the JavaFX application thread
    final String result = Datasource.getInstance().getCountryNameByCityName(selection);

    Platform.runLater(() -> countryTextField.setText(result));
}).start();