@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE})
public @interface AnotationList {
    Anotation[] value () default {};
}