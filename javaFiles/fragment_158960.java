public class Repository<T, D extends AbstractDao<T>>  {
    private D db;

    Repository(D dao) {
        db = dao;
    }

    public void save(List<T> items) { db.insertOrReplaceInTx(items); }
    public List<T> all()  { return db.loadAll(); }
    public T get(Long id) { return db.load(id);  }
}