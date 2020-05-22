@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(MissingGenericBeanCondition.class)
public @interface ConditionalOnMissingGenericBean {

    Class<?> containerType() default Void.class;
    Class<?>[] typeParameters() default {};
}