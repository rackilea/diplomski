@Override
public void process(AGateway aGateway, Message.MessageTypes messageTypes, InboundMessage inboundMessage) {
   try {
         aGateway.deleteMessage(inboundMessage);
       } catch (TimeoutException | GatewayException | InterruptedException | IOException e) {
            e.printStackTrace();
       }
   // your logic here
}