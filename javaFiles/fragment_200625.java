import com.sun.mail.iap.Argument;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.UID;

public class CustomProtocolCommand implements IMAPFolder.ProtocolCommand {
    /** Index on server of first mail to fetch **/
    int start;

    /** Index on server of last mail to fetch **/
    int end;

    public CustomProtocolCommand(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Object doCommand(IMAPProtocol protocol) throws ProtocolException {
        Argument args = new Argument();
        args.writeString(Integer.toString(start) + ":" + Integer.toString(end));
        args.writeString("BODY[]");
        Response[] r = protocol.command("FETCH", args);
        Response response = r[r.length - 1];
        if (response.isOK()) {
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imap");
            props.setProperty("mail.mime.base64.ignoreerrors", "true");
            props.setProperty("mail.imap.partialfetch", "false");
            props.setProperty("mail.imaps.partialfetch", "false");
            Session session = Session.getInstance(props, null);

            FetchResponse fetch;
            BODY body;
            MimeMessage mm;
            ByteArrayInputStream is = null;

            // last response is only result summary: not contents
            for (int i = 0; i < r.length - 1; i++) {
                if (r[i] instanceof IMAPResponse) {
                    fetch = (FetchResponse) r[i];
                    body = (BODY) fetch.getItem(0);
                    is = body.getByteArrayInputStream();
                    try {
                        mm = new MimeMessage(session, is);
                        Contents.getContents(mm, i);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        // dispatch remaining untagged responses
        protocol.notifyResponseHandlers(r);
        protocol.handleResult(response);

        return "" + (r.length - 1);
    }
}