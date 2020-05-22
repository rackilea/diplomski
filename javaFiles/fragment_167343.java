public interface AccountRepository 
    extends JpaRepository<Account, Long>, AccountRepositoryCustom { ... }

public interface AccountRepositoryCustom {
    public void customMethod();
}