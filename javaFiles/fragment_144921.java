@Entity
public class File {

   ...existing fields...

   @ContentId
   private UUID contentId;

   @ContentLength
   private long contentLength = 0L;

   // if you have rest endpoints
   @MimeType
   private String mimeType;

   ...
}