public abstract class JpaRepository<E, K> {

public abstract void create(E entity);

public abstract void edit(E entity) throws Exception;

public abstract void remove(K key) throws IllegalOrphanException, NonexistentEntityException;

public abstract List<E>  findAll();

public abstract E findOne(K key);

public abstract int count();