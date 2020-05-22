@MessageDriven(mappedName = "ExampleMDB")
public class MessageProcessor implements MessageListener {

  public MessageProcessor() {
  }

  public void onMessage(Message message) {

    System.out.println("message received");

  }
}