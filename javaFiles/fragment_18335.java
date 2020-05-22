@XmlRootElement(name = "root")
public class Root {

    private Entity entity;

    static class Entity {

    }

    static class EntityWrapper {
        @XmlElement(name = "entity")
        private Entity entity;

        public Entity getEntity() {
            return entity;
        }
    }

    @XmlElement(name = "wrapper")
    private void setEntity(EntityWrapper entityWrapper) {
        entity = entityWrapper.getEntity();
    }

}