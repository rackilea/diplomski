public class MagazinePreview 
{
  @Attribute
  String title;
  @Attribute
  String id;
  @Element
  String description;
  @Element(name="miniatura")
  String miniatureUrl;
  Bitmap miniature;
  public MagazinePreview(String title, String id, 
                         String description, String miniatureUrl) 
  {
    super();
    ...
  }   
}