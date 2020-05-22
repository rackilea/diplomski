public class LoginDataBase extends SQLiteOpenHelper {
private static final String DB_NAME="Login_DB";
private static final int DB_VERSION=1;


public LoginDataBase (Context contexto, String name,
                           CursorFactory factory, int version) {
    super(contexto, name, factory, version);
}