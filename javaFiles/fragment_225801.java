@Component
class SomeComponent {

  private final Repositories repositories;

  SomeComponent(Repositories repositories) {
    this.repositories = repositories;
  }

  void someMethod(Object someEntity) {

    PersistentEntity<?> entity = repositories.getPersistentEntity(someEntity.getClass());
    …
  }
}