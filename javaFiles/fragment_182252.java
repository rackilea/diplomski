@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty(
           propertyName = "destination", 
           propertyValue = "InboundXMLQueueHandlerST,InboundXMLQueueHandlerMT")})
public class InboundXMLQueueHandler implements MessageListener {
...