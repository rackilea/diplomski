/**
 * @param type A fully qualified Java type
 */
public Object create(String type) throws Exception {
  return Class.forName(type).newInstance();
}