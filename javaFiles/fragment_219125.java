public class JacksonPolymorphism {

    public static class BaseEntity {
        private final String id;

        protected BaseEntity(String id) {
            this.id = id;
        }
    }

    public static class Site extends BaseEntity {
        private final String siteName;
        private final List<Instance> instances;

        @JsonCreator
        public Site(@JsonProperty("id") String id,
                    @JsonProperty("siteName") String siteName,
                    @JsonProperty("instances") List<Instance> instances) {
            super(id);
            this.siteName = siteName;
            this.instances = instances;
        }

        @Override
        public String toString() {
            return "Site{" +
                    "siteName='" + siteName + '\'' +
                    ", instances=" + instances +
                    '}';
        }
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "@type")
    @JsonTypeName(value = "simple")
    public static class Instance extends BaseEntity {
        private final String name;

        @JsonCreator
        public Instance(@JsonProperty("instanceId") String id,
                        @JsonProperty("name") String name) {
            super(id);
            this.name = name;
        }

        @Override
        public String toString() {
            return "Instance{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @JsonTypeName("cloud")
    public static class CloudInstance extends Instance {
        private final String availabilityZone;
        private final String instanceType;


        public CloudInstance(@JsonProperty("instanceId") String id,
                             @JsonProperty("name") String name,
                             @JsonProperty("availabilityZone") String availabilityZone,
                             @JsonProperty("instanceType") String instanceType) {
            super(id, name);
            this.availabilityZone = availabilityZone;
            this.instanceType = instanceType;
        }

        @Override
        public String toString() {
            return "CloudInstance{" +
                    "availabilityZone='" + availabilityZone + '\'' +
                    ", instanceType='" + instanceType + '\'' +
                    '}';
        }
    }

    public static final String JSON = "{\n" +
            "        \"id\": null,\n" +
            "        \"siteName\": \"demo\",\n" +
            "        \"instances\": [\n" +
            "            {\n" +
            "                \"@type\": \"cloud\",\n" +
            "                \"instanceId\": \"i-8c2ee5fc\",\n" +
            "                \"name\": \"some-node\",\n" +
            "                \"availabilityZone\": \"some-zone\",\n" +
            "                \"instanceType\": \"t1.micro\"  \n" +
            "            }," +
            "            {\n" +
            "                \"@type\": \"simple\",\n" +
            "                \"instanceId\": \"ABC\",\n" +
            "                \"name\": \"FGF\"\n" +
            "            }]" +
            "   }";
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(CloudInstance.class);
        System.out.println(mapper.readValue(JSON, Site.class));
    }

}