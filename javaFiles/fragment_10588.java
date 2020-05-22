public class OEntityHolder {
    private final OEntity entity;
    private Queue<String> properties;

    public OEntityHolder(OEntity entity) {
        this.entity = entity;
        this.properties = new LinkedBlockingQueue<>();
    } 

    public OEntity getEntity() {
        return this.entity;
    }

    public void addProperty(String property) {
        this.properties.add(property);
    }

    public void removeProperty() {
        this.properties.poll();
    }
}