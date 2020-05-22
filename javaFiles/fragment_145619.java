public class Factory<T> {
  public T getById(ObjectId id) {
    return datastore.get(T, id);
  }
}

public class Class1Factory extends Factory<Class1> {
  public Class1 getById(ObjectId id) {
    return datastore.get(Class1.class, id);
  }
}