public class BundleDemo {
    private static final String BUNDLE_NAME = "Messages";

    @BundleDemo.Message(BundleDemo.BUNDLE_NAME)
    public String foo;

    public static void main(String[] args) throws Exception {
        for(Field field : BundleDemo.class.getFields()) {
            Message message = field.getAnnotation(Message.class);
            ResourceBundle bundle = ResourceBundle.getBundle(message.value());
            String value = bundle.getString(field.getName());
            System.out.println(value);
        }
    }

    @Retention(value = RetentionPolicy.RUNTIME)
    @Target(value = ElementType.FIELD)
    public @interface Message {
        String value();
    }
}