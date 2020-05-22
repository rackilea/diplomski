try {
  MqttAsyncClient mqttAsyncClient = new MqttAsyncClient(brokerUri, clientId, memoryPersistence);
  MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
  mqttConnectOptions.setCleanSession(true);
  mqttAsyncClient.setCallback(this);
  mqttAsyncClient.connect(mqttConnectOptions, null, new MqttAsyncActionListener() {
    public void onSuccess(IMqttToken asyncActionToken) {
      MqttMessage mqttMessage = new MqttMessage();
      mqttMessage.setPayload(payload.getBytes());
      mqttAsyncClient.publish(topic, mqttMessage);
    }

    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
      exception.printStackTrace();
    }
});

} catch (MqttException e) {
  e.printStackTrace();
}