IMqttToken conToken;
  conToken = asyncClient.connect("some context", new MqttAsyncActionListener() {
      public void onSuccess(IMqttToken asyncActionToken) {
        log("Connected");
      }

      public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
        log ("connect failed" +exception);
      }
});