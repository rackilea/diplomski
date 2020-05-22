TextArea textArea = new TextArea("YOUR_MESSAGE_HERE");
textArea.setEditable(false);
textArea.setWrapText(true);
GridPane gridPane = new GridPane();
gridPane.setMaxWidth(Double.MAX_VALUE);
gridPane.add(textArea, 0, 0);

Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Stuff");
alert.getDialogPane().setContent(gridPane);
alert.showAndWait();