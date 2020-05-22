@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MapAppender {
    String[] keys();
    String[] values();
}