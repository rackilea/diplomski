public class Version {

       private List<Versions> versions;

       public List<Versions> getVersions() {
           return versions;
       }

       public void setVersions(List<Versions> versions) {
           this.versions = versions;
       }

       @Override
       public String toString() {
           return "Version [versions=" + versions + "]";
       }
}

public class Versions {

    private String  id;
    private String  time;
    private String  releaseTime;
    private String  type;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getReleaseTime() {
        return releaseTime;
    }
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Versions [id=" + id + ", time=" + time + ", releaseTime="
                + releaseTime + ", type=" + type + "]";
    }
}