// UNTESTED!
public interface Repository<E> {
    @Transactional
    synchronized default void persist(E entity) {
        em.persist(entity);
    }
}