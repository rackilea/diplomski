public class Neo4JCustomIdStrategy implements IdStrategy {

  @Override
  public Object generateId(Object entity) {
    return String.valueOf(entity.hashCode());
  }
}