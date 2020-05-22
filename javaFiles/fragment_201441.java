@Target(ElementType.TYPE)
@Retention(RetentionType.SOURCE)
@interface MetaData {
  String table();
}

abstract class Entity {}

@MetaData(table="a")
class A extends Entity {}

@MetaData(table="b")
class B extends Entity {}

class EntityGetter {
  public <E extends Entity> E getEntity(Class<E> type) {
    MetaData metaData = type.getAnnotation(MetaData.class);
    if (metaData == null) {
      throw new Error("Should have been compiled with the preprocessor.");
      // Yes, do throw an Error. It's a compile-time error, not a simple exceptional condition.
    }
    String table = metaData.table();
    // do whatever you need.
  }
}