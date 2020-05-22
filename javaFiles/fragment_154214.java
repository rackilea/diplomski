@FXML
protected void searchButtonAction() {
    maskerPane.setVisible(true);

    cardNumber = cardNumberTextField.getText();

    JSONObject jsonRequest = new JSONObject()
    .put("id", cardNumber)
    .put("trans", 20);
    Task<JSONObject> jsonRequestTask = new Task<JSONObject>() {
        @Override
        public JSONObject call() {
            return sendRESTRequest(jsonRequest);
        }
    };

    jsonRequestTask.setOnSucceeded(event -> {
        JSONObject loyaltyResponse = jsonRequestTask.getValue();

        currentValueLabel.setText(loyaltyResponse.getString("amount").replace(".", ",") + " Currency");
        maximumValueLabel.setText(loyaltyResponse.getString("balanceMax").replace(".", ",") + " Currency");

        maskerPane.setVisible(false);
    }

    jsonRequestTask.setOnFailed(event -> {
        maskerPane.setVisible(false);
    });

    new Thread(jsonRequestTask).start();
}

private JSONObject sendRESTRequest(JSONObject jsonRequest) {
    HttpResponse<JsonNode> jsonResponse = null;
    try {
        jsonResponse = Unirest.post("http://myurl/")
        .header("accept", "application/json")
        .body(jsonRequest)
        .asJson();
    } catch (UnirestException e) {
        e.printStackTrace();
    }

    return jsonResponse.getBody().getObject();
}