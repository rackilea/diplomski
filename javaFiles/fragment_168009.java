public class JacksonJsonIdentityInfo {
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
    static class Bean {
        public final String field;

        public Bean(final String field) {this.field = field;}
    }

    static class Bean2 {
        public final String field2;

        public Bean2(final String field2) {this.field2 = field2;}
    }

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id2")
    static interface Bean2MixIn {
    }

    static class Bean3 {
        public final String field3;

        public Bean3(final String field3) {this.field3 = field3;}
    }

    static class MyJacksonAnnotationIntrospector extends JacksonAnnotationIntrospector {
        @Override
        public ObjectIdInfo findObjectIdInfo(final Annotated ann) {
            if (ann.getRawType() == Bean3.class) {
                return new ObjectIdInfo(
                        PropertyName.construct("@id3", null),
                        null,
                        ObjectIdGenerators.IntSequenceGenerator.class,
                        null);
            }
            return super.findObjectIdInfo(ann);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        final Bean bean = new Bean("value");
        final Bean2 bean2 = new Bean2("value2");
        final Bean3 bean3 = new Bean3("value3");
        final ObjectMapper mapper = new ObjectMapper();
        mapper.addMixInAnnotations(Bean2.class, Bean2MixIn.class);
        mapper.setAnnotationIntrospector(new MyJacksonAnnotationIntrospector());
        System.out.println(mapper.writeValueAsString(bean));
        System.out.println(mapper.writeValueAsString(bean2));
        System.out.println(mapper.writeValueAsString(bean3));
    }    
}