@Root
public class MagazinePreviews
{
  @ElementList(name="magazines")
  ArrayList<MagazinePreviews> previews;

  public static MagazinePreviews Load(String xml)
  {
    Serializer serializer = new Persister();
    return serializer.read(MagazinePreviews.class, xml);
  }
}