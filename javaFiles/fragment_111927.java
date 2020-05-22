public abstract class CustomizableQueriesForClazzAndFields<T extends EntityClass> {
  public List<T> getMultipleClazzWithFields(final Class<T> clazz, final String ...fields){
    return of(clazz).retrieve(fields);
  }

  private MyCriteria of(final Class<T> applyToClazz) {
     ...
  }
}