@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@interface PredicateMeta {
    String name();
    int data();
    String operator();
}