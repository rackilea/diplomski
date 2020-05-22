public abstract class AbstractController<IDT extends Serializable, KT extends Serializable,
    Dom extends DomainObject<IDT>, T extends PagingAndSortingRepository<Dom, KT>> {

  private T repository;

  public AbstractController(T repository) {
    this.repository = repository;
  }

  public Dom get(IDT objectId) {
    return repository.get(objectId);
  }
}