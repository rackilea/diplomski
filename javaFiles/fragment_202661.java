public class Main {
    public static void main(String[] args) {

        AbstractQueryRequest someType = new SomeType();

        for(Method method : x.getClass().getSuperclass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(JsonProperty.class)) {
                JsonProperty annotation = method.getAnnotation(JsonProperty.class);
                System.out.println(annotation.value());
            }
        }
    }
}


class SomeType extends AbstractQueryRequest {

    @Override
    public String reqid() {
        return null;
    }

    @Override
    public String rawquery() {
        return null;
    }
}