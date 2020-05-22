public class AttachmentInterceptor implements ClientInterceptor {
Iterator<Attachment> attachments;

@Override
public boolean handleResponse(MessageContext msgCtx) throws WebServiceClientException {
    WebServiceMessage msg = msgCtx.getResponse();
    if (msg instanceof SaajSoapMessage) {
        SaajSoapMessage sm = (SaajSoapMessage) msg;
        attachments = sm.getAttachments();
        return false;
    } else {
        return true;
    }
}

public Iterator<Attachment> getAttachments() {
    return attachments; 
}...