/**
 * Shortcut and more descriptive "alias" for {@code @Transactional(propagation = Propagation.MANDATORY)}.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(propagation = Propagation.MANDATORY)
public @interface RequiresExistingTransaction {
}