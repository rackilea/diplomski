@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyEventAnnotation
{
   String topic() default "";
}