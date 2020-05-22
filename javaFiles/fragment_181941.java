import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;
public class MyMimeMultyPart extends MimeMultipart {
    /**
     * DataSource that provides our InputStream.
     */
    protected DataSource ds;

    /**
     * Indicates if the data has been parsed.
     */
    protected boolean parsed = true;

    private ContentType type;

    public MyMimeMultyPart(DataSource dataSource) throws MessagingException {
        super(dataSource);
    }

    public MyMimeMultyPart(String subtype) {
        type = new ContentType("multipart", subtype, null);
        type.setParameter("boundary", getBoundary());
        contentType = type.toString();
    }

    public MyMimeMultyPart() {
        super();
    }

    private static int part;

    private synchronized static String getBoundary() {
        int i;
        synchronized (MimeMultipart.class) {
            i = part++;
        }
        StringBuffer buf = new StringBuffer(64);
        buf.append("----=_Part_").append(i).append('_').append((new Object()).hashCode()).append('.').append(System.currentTimeMillis());
        return buf.toString();
    }
}