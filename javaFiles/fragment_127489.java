@EJB   // key difference
private EmailQueueMessenger eqm;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
public void sendMessage(Object messageObject) {
   eqm.sendEmail(messageObject);
}