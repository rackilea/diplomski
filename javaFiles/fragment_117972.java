public class Issuelink {
    private String id;
    private String self;
    private Type type;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSelf() {
        return self;
    }
    public void setSelf(String self) {
        this.self = self;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Issuelink [id=" + id + ", self=" + self + ", type=" + type
                + "]";
    }
}