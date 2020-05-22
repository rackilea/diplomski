public class PhotoRawScribe extends VCardPropertyScribe<PhotoRaw> {
  public PhotoRawScribe() {
    super(PhotoRaw.class, "PHOTO");
  }

  @Override
  protected VCardDataType _defaultDataType(VCardVersion version) {
    return null;
  }

  @Override
  protected String _writeText(PhotoRaw property, VCardVersion version) {
    return property.getValue();
  }

  @Override
  protected PhotoRaw _parseText(String value, VCardDataType dataType, VCardVersion version, VCardParameters parameters, List<String> warnings) {
    return new PhotoRaw(value);
  }
}

public class PhotoRaw extends SimpleProperty<String> {
  public PhotoRaw(String value) {
    super(value);
  }

  public static void main(String args[]) throws Exception {
    String str = 
    "BEGIN:VCARD\r\n" +
    "VERSION:4.0\r\n" +
    "PHOTO:foobar\r\n" +
    "END:VCARD";

    VCardReader reader = new VCardReader(str);
    reader.registerScribe(new PhotoRawScribe());
    VCard vcard = reader.readNext();

    PhotoRaw photo = vcard.getProperty(PhotoRaw.class);
    System.out.println(photo.getValue()); //prints "foobar"
  }
}