class EntitiesOwner {

    private String name;
    private List<Entity> entities;

    @JsonAnySetter
    public void setProperties(String name, List<Entity> entities) {
        this.name = name;
        this.entities = entities;
    }

    public String getName() {
        return name;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "EntitiesOwner [name=" + name + ", entities=" + entities + "]";
    }
}

class Entity {

    private int id;
    private String afk;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAfk() {
        return afk;
    }

    public void setAfk(String afk) {
        this.afk = afk;
    }

    public void setCat(String cat) {
        this.afk = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", afk=" + afk + ", name=" + name + "]";
    }
}