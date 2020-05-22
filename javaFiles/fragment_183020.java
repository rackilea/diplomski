public class AppActivity extends Application {

AppDatabase db;

@Override
public void onCreate() {
    super.onCreate();
    db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();
}

public AppDatabase getDatabase() {
    return db;
}