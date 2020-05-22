@NoRepositoryBean
public interface ABaseRepository<T extends A> 
extends CrudRepository<T, Long> {
  // All methods in this repository will be available in the ARepository,
  // in the BRepository and in the CRepository.
  // ...
}