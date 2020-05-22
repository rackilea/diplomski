@FXML
protected void connect() throws IOException {
        if (!hostFiled.getText().equals("")) {
            host = hostFiled.getText();
        }
        if (!portFiled.getText().equals("")) {
            port = Integer.parseInt(portFiled.getText());
        }
        connecting.setText("Connecting...");

        stage = (Stage) connect.getScene().getWindow();
        Connect conCasp = new Connect(host, port);

        conCasp.setOnSucceeded(event -> closeWindow());

        new Thread(conCasp).start();

}