@With(RepeatableAction2Impl.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatableAction2 {
    Action2[] value() default {};
}