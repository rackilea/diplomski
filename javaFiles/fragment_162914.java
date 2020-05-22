// Interface for custom functionality
interface SomeCustomRepository {
  void updateMethod(…);
}

// Custom implementation
class FooRepositoryImpl implements SomeCustomRepository {

  public void updateMethod(…) {
    mongoTemplate.update(…);
  }
}

// Core repository declaration combining CRUD functionality and custom stuff
interface FooRepository extends CrudRepository<Foo, ObjectId>, SomeCustomRepository {
  …
}