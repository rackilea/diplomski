public class Cache {

    private final ClassValue<String> backend = new ClassValue<String>() {
        @Override
        protected String computeValue(Class<?> entity) {
            return createHql(entity);
        }
    };

    public String getHqlFor(Class<?> entity){
        return backend.get(entity);
    }
}