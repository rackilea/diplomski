@ServiceProvider(service = MIMEResolver.class, position = 3214328)
public class FilenameResolver extends MIMEResolver {

  private static final String mimetype = "text/plain+something";

  public FilenameResolver() {
    super(mimetype);
  }

  @Override
  public String findMIMEType(FileObject fo) {
    String nameExt = fo.getNameExt();
    if (".something".equalsIgnoreCase(nameExt)) {
      return mimetype;
    }
    return null;
  }

}