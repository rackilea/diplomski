/**
 * A qualifier value for the specified transaction.
 * <p>May be used to determine the target transaction manager,
 * matching the qualifier value (or the bean name) of a specific
 * {@link org.springframework.transaction.PlatformTransactionManager}
 * bean definition.
 */
String value() default "";