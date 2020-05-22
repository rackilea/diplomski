public class Project {
    private String self;
    private String id;
    private String key;
    private String name;
    private AvatarUrls avatarUrls;
    public String getSelf() {
        return self;
    }
    public void setSelf(String self) {
        this.self = self;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public AvatarUrls getAvatarUrls() {
        return avatarUrls;
    }
    public void setAvatarUrls(AvatarUrls avatarUrls) {
        this.avatarUrls = avatarUrls;
    }
    @Override
    public String toString() {
        return "Project [self=" + self + ", id=" + id + ", key=" + key
                + ", name=" + name + ", avatarUrls=" + avatarUrls + "]";
    }
}