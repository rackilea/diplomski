@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@MessageMapping
@Documented
@RabbitListener(id = "example", queues = {"a", "b"})
public @interface MyRabbitListener {

    @AliasFor(annotation = RabbitListener.class)
    String containerFactory() default "";

    @AliasFor(annotation = RabbitListener.class)
    boolean exclusive() default false;

    @AliasFor(annotation = RabbitListener.class)
    String priority() default "";

    @AliasFor(annotation = RabbitListener.class)
    String admin() default "";

    @AliasFor(annotation = RabbitListener.class)
    QueueBinding[] bindings() default {};

    @AliasFor(annotation = RabbitListener.class)
    String group() default "";
}