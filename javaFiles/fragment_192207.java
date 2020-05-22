interface Cache {
// Your caching methods
}

class CacheImpl implements Cache {

    private SharedPreferences sharedPrefs;

    public CacheImpl(Context context) {
        // Takes a context to init sharedPrefs.
    }

    // implements all of Cache's methods
}