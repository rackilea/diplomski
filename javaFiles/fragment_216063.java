public class JacksonXmlAnnotation {
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface JsonOnly {
    }

    @JacksonXmlRootElement(localName = "root")
    public static class User {
        public final Integer userId;
        public final String name;
        @JsonOnly
        public final Integer groupId;

        public User(Integer userId, String name, Integer groupId) {
            this.userId = userId;
            this.name = name;
            this.groupId = groupId;
        }
    }

    public static class XmlAnnotationIntrospector extends JacksonXmlAnnotationIntrospector {
        @Override
        public boolean hasIgnoreMarker(AnnotatedMember m) {
            return m.hasAnnotation(JsonOnly.class) || super.hasIgnoreMarker(m);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        User user = new User(1, "John", 23);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setAnnotationIntrospector(new XmlAnnotationIntrospector());
        ObjectMapper jsonMapper = new ObjectMapper();
        System.out.println(xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
        System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
    }
}