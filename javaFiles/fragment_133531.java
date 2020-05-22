@NoRepositoryBean
public interface ABaseRepository<T> 
extends Repository<T, Long> {
  T findOne(Long id);
  Iterable<T> findAll();
  Iterable<T> findAll(Sort sort);
  Page<T> findAll(Pageable pageable);
}