public class DataStorage{

  private String title;

  private String description;

  private File audioFile;

  private File videoFile;

  public DataStorage(String title, String description, File audioFile, File videoFile){
    this.title = title;
    this.description = description;
    this.audioFile = audioFile;
    this.videoFile = videoFile;
  }

  public String getTitle(){
    return this.title;
  }
 //similar for "description", "audioFile" and "videoFile"
 //...
}