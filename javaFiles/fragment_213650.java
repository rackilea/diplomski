@Named
@ApplicationScoped
public class AppInfo {

  private String    revision; // + getter

  @PostConstruct
  public void init() {

    InputStream is = FacesContext.getCurrentInstance().getExternalContext()
                     .getResourceAsStream("/META-INF/MANIFEST.MF");
    Manifest manifest = new Manifest();
    try {
        manifest.read(is);
    } catch (IOException e) {
        // error handling
    } finally {
        try {
          is.close();
        } catch (IOException e) {
          // error handling
        }
    }
    Attributes attr = manifest.getMainAttributes();
    String implRevision = attr.getValue("Implementation-Build");
    String implVersion = attr.getValue("Implementation-Version");

    if (implRevision == null || implVersion == null)
        this.revision = "unknown";
    else
        this.revision = implVersion + " / " + implRevision;
  }
}