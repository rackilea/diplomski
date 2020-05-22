public void someBusinessLogic() {
    // loop to empty queue
    while (true) {
        // receive the message from the queue, wait at most 3 sec
        String msg = consumer.receiveBody("activemq:queue.inbox", 3000, String.class);
        if (msg == null) {
            // no more messages in queue
            break;
        }

        // do something with body
        msg = "Hello " + msg;

        // send it to the next queue
        producer.sendBodyAndHeader("activemq:queue.foo", msg, "number", count++);
    }
}