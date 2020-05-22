@NodeEntity
public class Version {

    Long id;

    String versionNumber;

    @Relationship(type = "HAS_VERSION", direction = "INCOMING")
    Application application;


    public Version() {
    }

    public Version(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Long getId() {
        return id;
    }
}