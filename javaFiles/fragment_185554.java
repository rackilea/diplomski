@ManagedBean(name="fileDownloadController", eager = true)
@ViewScoped
public class FileDownloadController implements Serializable{

   public StreamedContent generateFile(String fileName) {   
      InputStream stream = null;  
      try {
        stream = new FileInputStream("D:/myFileDir/"+fileName);
      } catch (FileNotFoundException ex) {

      }
      return new DefaultStreamedContent(stream, "image/jpg", fileName);  
   }