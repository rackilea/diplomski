public class Choice {
    String id;
    String description;
    String outSceneId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOutSceneId() {
        return outSceneId;
    }

    public void setOutSceneId(String outSceneId) {
        this.outSceneId = outSceneId;
    }

    @Override
    public String toString() {
        return "Choice{" + "description=" + description + '}';
    }

}