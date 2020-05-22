@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue =   "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/offlinemsg"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MessageHandlerMDB implements MessageListener {

private static final Logger log = Logger.getLogger(MessageHandlerMDB.class);


@Override
public void onMessage(Message message) {

    log.info("Message received in MessageHandlerMDB");


}

}