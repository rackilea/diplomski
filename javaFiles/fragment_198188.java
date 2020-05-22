/**
   This method is called asynchronously by JMS when a message arrives
   at the topic. Client applications must not throw any exceptions in
   the onMessage method.
   @param message A JMS message.
 */
public void onMessage(Message message)
{
    TextMessage msg = (TextMessage) message;
    try {
        System.out.println("received: " + msg.getText());
    } catch (JMSException ex) {
        ex.printStackTrace();
    }
}

/**
   This method is called asynchronously by JMS when some error occurs.
   When using an asynchronous message listener it is recommended to use
   an exception listener also since JMS have no way to report errors
   otherwise.
   @param exception A JMS exception.
 */
public void onException(JMSException exception)
{
    System.err.println("something bad happended: " + exception);
}