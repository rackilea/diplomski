public class DbObservable<T> extends Observable<T> {

    //Some parameter
    private String sql;

    protected DbObservable(DbOnSubscribe<T> onSub) {
        super(onSub);
    }

    //Getter for DbOnSubscribe
    public String getSql() {
        return sql;
    }

    //Chain parameter modifier
    public DbObservable<T> sql(String sql) {
        this.sql = sql;
        return this;
    }
}