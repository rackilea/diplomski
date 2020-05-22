@Transactional
public interface ARepository extends ABaseRepository<A> { /* ... */ }

@Transactional
public interface BRepository extends ABaseRepository<B> { /* ... */ }

@Transactional
public interface CRepository extends ABaseRepository<C> { /* ... */ }