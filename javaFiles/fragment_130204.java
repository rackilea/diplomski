@NodeEntity
public class Application {

    Long id;
    String name;
    @Relationship(type="HAS_VERSION", direction = "OUTGOING")
    Set<Version> versions = new HashSet<>();

    public Application() {
    }

    public Application(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addVersion(Version version) {
        versions.add(version);
    }

    public Set<Version> getVersions() {
        return versions;
    }

    public Long getId() {
        return id;
    }
}