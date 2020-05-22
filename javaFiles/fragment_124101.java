package de.sysvision.aviocheck.xml.generated;

    import java.util.List;

    import org.simpleframework.xml.Attribute;
    import org.simpleframework.xml.Element;
    import org.simpleframework.xml.ElementList;
    import org.simpleframework.xml.Root;

    @Root(strict = false)
    public class Object
    {
        @Attribute(name = "epc_memory")
        private String epcMemory;

        @Element(required = false)
        private String type;

        @Element(name = "type_id")
        private String typeId;

        @ElementList(inline = true)
        private List<Layer> layers;

        @ElementList(inline = true)
        private List<Property> properties;

        public String getEpcMemory() {
            return epcMemory;
        }

        public void setEpcMemory(String epcMemory) {
            this.epcMemory = epcMemory;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public List<Layer> getLayers() {
            return layers;
        }

        public void setLayers(List<Layer> layers) {
            this.layers = layers;
        }

        public List<Property> getProperties() {
            return properties;
        }

        public void setProperties(List<Property> properties) {
            this.properties = properties;
        }

    }