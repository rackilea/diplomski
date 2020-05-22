@Override
public void messageArrived(String topic, MqttMessage message) throws Exception {
  if (topic.equals(topic1) {
    temp.setText(new String(message.getPayload()));
  } else if (topic.equals(topic2) {
    foo.setText(new String(message.getPayload()));
  }
}