private void sendMessage(String message) {
 try {
    if (!jmsInitialized) {
        initJMS();
        sendTextMessage(message);
    }else{
        sendTextMessage(message);
    }
    } catch (JMSException e) {
        jmsInitialized = false;
        e.printStackTrace();
    }
  }
}