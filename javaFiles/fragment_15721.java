public class CardRepositoryDummy {

private final CardDao cardDao;
private final UserDao userDao;
private LiveData<List<Card>> cardListLiveData;
private DbHelper db;
private int keystage;
private static final String TAG = "CardRepo";

public CardRepositoryDummy(Application application) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
    keystage = sharedPreferences.getInt(Constants.SHARED_PREF_CARD_KEYSTAGE,0);
    db = DatabaseBuilder.getDatabase(application);
    cardDao = db.cardDaoLive();
    userDao = db.userDao();
}

public CardRepositoryDummy(Context application) {
    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
    keystage = sharedPreferences.getInt(Constants.SHARED_PREF_CARD_KEYSTAGE,0);
    db = DatabaseBuilder.getDatabase(application);
    cardDao = db.cardDaoLive();
    userDao = db.userDao();
}