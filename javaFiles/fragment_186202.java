public class DataUploadForm implements Serializable {
   static final long serialVersionUID = IL;

   @FormParam("xml")
   private String xml;

   @FormParam("file")
   private InputStream fileStream;

   public FileUploadForm() {
       super();
   }

   // Getters and setters here
}