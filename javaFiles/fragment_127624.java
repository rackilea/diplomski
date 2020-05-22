@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface GameIdParam {
    String name() default "My Game ID";

    String value() default "The integer ID of a particular game";
}