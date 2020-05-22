private boolean submitEvent(String ioMessage) {

    log.info("SEND");

    ZMQ.Context context = ZMQ.context();

    ZMQ.Socket sender = context.socket(ZMQ.PUSH);

    sender.connect("tcp://localhost:8086");

    sender.send("MESSAGE");

    sender.close();

    context.term(); 

    return true;

}