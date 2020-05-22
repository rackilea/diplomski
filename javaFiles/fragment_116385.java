/**
 * The real class to do what you want to do.
 */
public class RealClass {

private IDatabase dbInstance = null;

    private IDatabase getDbInstance() {
        if (dbInstance == null) {
            dbInstance = new Database();
        }
        return dbInstance;
    }

    protected void setDbInstance(IDatabase dataBase) {
        dbInstance = dataBase;
    }

    public static void main(String[] args) {
        getDbInstance().insert(yourParam);

    }
}