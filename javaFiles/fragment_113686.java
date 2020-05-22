while(true){
        Message message = consumer.receive(//some int timeout);
        if (message == null)
        {
            break;
        }

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("message from queue : '" + textMessage.getText() + "'");
        }
}