public class FooListener implements IMqttMessageListener {

  ExecutorService pool = new ExecutorService(10);

  class MessageHandler implements Runnable {
    MqttMessage message;
    String topic;

    public MessageHandler(String topic; MqttMessage message) {
      this.message = message;
    }

    public void run() {
      //process message
    }
  }

  @Override
  public void messageArrived(String topic, MqttMessage message) throws Exception {
    pool.execute(new MessageHandler(topic,message));
  }
}