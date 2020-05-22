private static class Request {
    public byte[] send;
    public ServerReplyHandler handler;
};

private BlockingQueue<Request> requestQueue;

public static callServer(Object inputs, ServerReplyHandler handler) {

    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    new ObjectOutputStream(byteStream).writeObject(inputs);

    Request r = new Request();
    r.send = byteStream.toByteArray();
    r.handler = handler;
    requestQueue.put(r);
}