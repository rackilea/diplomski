public class DAOProxyAdapter implements DAO {
  private DAO target;
  public DAOProxyAdapter(DAO target) { this.target = target; }
  public void insert(Object o) {target.insert(o); }
  public void delete(Object o) {target.delete(o); }
  public void update(Object o) {target.update(o); }
  public Object find(Object key) { return target.find(key); }
}
public class NoDeleteProxy extends DAOProxyAdapter {
  public NoDeleteProxy(DAO target) {super(target);}
  public void delete(Object o) { throw new UnsupportedOperationException(); }
}