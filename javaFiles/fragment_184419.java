@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional("tenantTransactionManager")
public @interface TenantTransactional {

  @AliasFor(attribute="readOnly", annotation=Transactional.class)
  boolean readOnly() default false;
}