public class JacksonFilter {
    static private boolean shouldIncludeAllFields;

    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Admin {}

    @JsonFilter("admin-filter")
    public static class User {
        public final String email;
        @Admin
        public final String details;

        public User(String email, String details) {
            this.email = email;
            this.details = details;
        }
    }

    public static class AdminPropertyFilter extends SimpleBeanPropertyFilter {

        @Override
        protected boolean include(BeanPropertyWriter writer) {
            // deprecated since 2.3
            return true;
        }

        @Override
        protected boolean include(PropertyWriter writer) {
            if (writer instanceof BeanPropertyWriter) {
                return shouldIncludeAllFields || ((BeanPropertyWriter) writer).getAnnotation(Admin.class) == null;
            }
            return true;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        User user = new User("email", "secret");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setFilters(new SimpleFilterProvider().addFilter("admin-filter", new AdminPropertyFilter()));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
        shouldIncludeAllFields = true;
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
    }

}