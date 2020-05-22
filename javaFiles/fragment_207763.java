@Entity
public class Image {

   // replace @Lob/byte array field with:

   @ContentId
   private String contentId;

   @ContentLength
   private long contentLength = 0L;

   @MimeType
   private String mimeType;