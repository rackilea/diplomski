class TransactionalMethodInterceptor implements MethodInterceptor {

  @javax.inject.Inject
  private EntityManager em;

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    try {
      Object result = invocation.proceed();
      em.commit();
    } catch (Exception e) {
      em.rollback();
      throw e;
    }
  }