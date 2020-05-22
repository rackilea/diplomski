@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        ...
        try {
          ...
        } catch (Exception e) {

            if (trx != null && trx.isActive() && criador) {
                trx.rollback();
                throw new RuntimeException("Transaction rolled back!", e);
            }

        } 

        return obj;
    }

}

// transactional bean
public class SalvarExecutor {
@Transactional
public boolean salvar(Funcionario funcionario) {
   return funcionarioDAOImpl.salvar(funcionario);
}
}

// caller CDI bean
public class Caller {
  @Inject SalvarExecutor executor;

  public void execute() {
    try {
      salvar.salvar();
    } catch (Exception e) {
      // salvar was rolled back by the interceptor
    }
  }
}