public class MyInterceptor extends AbstractPhaseInterceptor<Message> {
    public MyInterceptor () {
        super(Phase.RECEIVE);
    }

    public void handleMessage(Message message) {
        //Get the message body into payload[] and set a new non-consumed  inputStream into Message
        InputStream in = message.getContent(InputStream.class);
        byte payload[] = IOUtils.readBytesFromStream(in);
        ByteArrayInputStream bin = new ByteArrayInputStream(payload);
        message.setContent(InputStream.class, bin);
    }

    public void handleFault(Message messageParam) {
        //Invoked when interceptor fails
    }
}