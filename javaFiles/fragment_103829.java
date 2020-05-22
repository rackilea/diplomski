Message message = (Message) in.readObject();
if (message instanceof TextMessage) {
    // do something with ((TextMessage)message).text
} else if (message instanceof DataMessage) {
    // do something with ((DataMessage)message).user
}