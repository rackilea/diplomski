public class Controller extends Application {

    public static final int SIGNUP_REQUEST = 98;  // The request code
    public static final int SIGNIN_REQUEST = 99;
    private User mUser;// Instance de l'utilisateur connecté
    private Cart mCart = new Cart(); // Panier
    private Tracker mTracker; // Analytics
    private Session mSession;
    private SessionModule mSessionModule;
    private static Controller _mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        _mInstance = this;

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        mSessionModule = new SessionModule(base);
        mSession = mSessionModule.getSession();
    }

    public static synchronized Controller getInstance() {
        return _mInstance;
    }

    public Cart getCart() {

        return mCart;
    }

    public Session getSession() {
        return mSession;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User mUser) {
        this.mUser = mUser;
    }
}