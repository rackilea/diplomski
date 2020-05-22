public class MyInterceptor extends AbstractPhaseInterceptor<Message> {

    public MyInterceptor () {
        super(Phase.MARSHAL);
    }

    public final void handleMessage(Message message) {
        MultivaluedMap<String, Object> headers = (MetadataMap<String, Object>) message.get(Message.PROTOCOL_HEADERS);

        if (headers == null) {
            headers = new MetadataMap<String, Object>();
        }             

        //generate E-tag here
        String etag = getEtag();
        // 
        String cc = 600;

        headers.add("E-Tag", etag);
        headers.add("Cache-Control", cc);
        message.put(Message.PROTOCOL_HEADERS, headers);
    }
}