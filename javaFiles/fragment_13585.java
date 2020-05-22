public void onSuccess(String response) {
     try {
        JsonRepresentation jRep = new JsonRepresentation(response);
        dialogBox.setText("Update contact"
                  + jRep.getJsonObject().get("lastName"));
     } catch (IOException e) {
     }