@MessageDriven(
    name="InboundXMLQueueHandlerST,InboundXMLQueueHandlerMT",
    activationConfig = {
        @ActivationConfigProperty(
           propertyName = "destinationType", 
           propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(
           propertyName = "destination", 
           propertyValue = "InboundXMLQueueHandlerST,InboundXMLQueueHandlerMT")})
public class InboundXMLQueueHandler implements MessageListener {
...