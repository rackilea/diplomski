public class MultipartSigned extends MimeMultipart {
    public MultipartSigned() {
        super("signed");
        ContentType ct = new ContentType(contentType);
        ct.setParameter("protocol", "application/pkcs7-signature");
        contentType = ct.toString();
    }
}