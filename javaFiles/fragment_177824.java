private void sendObjectToQueue(Serializable object) {


    Session session = null;
    MessageProducer sender = null;
    Connection connect = null;

    if (logger.isDebugEnabled()) {
    logger.debug("Entered sendObjectToQueue(" + object.getClass());
    }

    try {

        Context context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context
                .lookup("ConnectionFactory");

        Queue queue = (Queue) context.lookup("queue/offlinemsg");
        connect = factory.createConnection();
        session = connect.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        sender = session.createProducer(queue);

        ObjectMessage message = session.createObjectMessage();

        message.setObject(object);
        sender.send(message);
        sender.close();
        connect.close();

        if (logger.isDebugEnabled()) {
        logger.debug("The " + object.getClass() + " object was sent to jms queue");
        }

    } catch (JMSException e) {
        logger.error("Sending object to queue failed", e);


    } catch (Exception e) {
        logger.error("Sending object to queue failed", e);


    } finally {

        if (sender != null) {
            try {
                sender.close();
                if (logger.isDebugEnabled()) {
                    logger.debug("Closed jms session");
                }
            } catch (JMSException e) {
                logger.error("Closing jms session failed", e);
            }
        }

        if (connect != null) {
            try {
                connect.close();
                if (logger.isDebugEnabled()) {
                    logger.debug("Closed jms session");
                }
            } catch (Exception e) {
                logger.error("Closing jms session failed", e);
            }
        }

        if (session != null) {
            try {
                session.close();
                if (logger.isDebugEnabled()) {
                    logger.debug("Closed jms session");
                }
            } catch (Exception e) {
                logger.error("Closing jms session failed", e);
            }
        }
    }
}