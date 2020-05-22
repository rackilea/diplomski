@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IntegerSet {
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;
}