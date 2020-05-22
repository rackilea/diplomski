public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mygame.db";
    public static final int DBVERSION = 1;

    public static final String TBL_USER = "user";
    public static final String COL_USER_ID = BaseColumns._ID;
    public static final String COL_USER_NAME = "user_name";
    public static final String COL_USER_EMAIL = "user_email";
    public static final String COL_USER_PASWWORD = "user_password";
    public static final String COL_USER_COINS = "user_coins";
    public static final String COL_USER_GEMS = "user_gems";

    public static final String TBL_PLAYER = "player";
    public static final String COL_PLYAER_ID = BaseColumns._ID;
    public static final String COL_PLAYER_OWNINGUSER = "player_owninguser";
    public static final String COL_PLAYER_NAME = "player_name";
    //...... other columns


    SQLiteDatabase mDB;
    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String crt_tbl_user = "CREATE TABLE IF NOT EXISTS " + TBL_USER + "(" +
                COL_USER_ID + " INTEGER PRIMARY KEY," +
                COL_USER_NAME + " TEXT NOT NULL UNIQUE," +
                COL_USER_EMAIL + " TEXT NOT NULL UNIQUE," +
                COL_USER_PASWWORD + " TEXT NOT NULL," +
                COL_USER_COINS + " INTEGER," +
                COL_USER_GEMS + " INTEGER" +
                ")";

        String crt_tbl_player = "CREATE TABLE IF NOT EXISTS " + TBL_PLAYER + "(" +
                COL_PLYAER_ID + " INTEGER PRIMARY KEY," +
                COL_PLAYER_NAME + " TEXT NOT NULL," +
                COL_PLAYER_OWNINGUSER + " INTEGER REFERENCES " + TBL_USER + "(" + COL_USER_ID + ")" +
                ")";
        db.execSQL(crt_tbl_user);
        db.execSQL(crt_tbl_player);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    /*
        Note core add but not intended to be used directly
        Note this assumes that checks are done to ensure that name, email and password
            have been provided
     */
    private long addUser(Long id, String name, String email, String password, int coins, int gems) {
        ContentValues cv = new ContentValues();
        if (id > 0) {
            cv.put(COL_USER_ID,id);
        }
        if (name.length() > 0) {
            cv.put(COL_USER_NAME,name);
        }
        if (email.length() > 0 ) {
            cv.put(COL_USER_EMAIL,email);
        }
        if (password.length() > 0) {
            cv.put(COL_USER_PASWWORD,password);
        }
        cv.put(COL_USER_COINS,coins);
        cv.put(COL_USER_GEMS,gems);
        if (cv.size() < 1) return -1; //<<<<<<<<<< return if nothing to add
        return mDB.insert(TBL_USER,null,cv);
    }

    /*
        For add with just name, email and password (normal usage)
     */
    public long addUser(String name, String email, String password) {
        return this.addUser(-1L,name,email,password,0,0);
    }

    /*
        For adding a user setting the coins and gems (special usage)
     */
    public long addUserSettingCoinsAndGems(String name, String email, String password, int coins, int gems) {
        return  this.addUser(-1L,name,email,password,coins,gems);
    }

    public User getUser(long id) {
        User rv = new User("-1","",",",""); // Invalid user
        String whereclause = COL_USER_ID + "=?";
        String[] whereargs = new String[]{String.valueOf(id)};
        Cursor csr = mDB.query(TBL_USER,null,whereclause,whereargs,null,null,null);
        if (csr.moveToFirst()) {
            rv.setId(String.valueOf(id));
            rv.setName(csr.getString(csr.getColumnIndex(COL_USER_NAME)));
            rv.setEmail(csr.getString(csr.getColumnIndex(COL_USER_EMAIL)));
            rv.setPassword(csr.getString(csr.getColumnIndex(COL_USER_PASWWORD)));
            rv.setCoins(csr.getInt(csr.getColumnIndex(COL_USER_COINS)));
            rv.setGems(csr.getInt(csr.getColumnIndex(COL_USER_GEMS)));
        }
        csr.close();
        return rv;
    }

    public User getUser(String userid) {
        String whereclause = COL_USER_ID + "=?";

        User rv = new User("-1","",",",""); // Invalid user
        long id;
        try {
            id = Long.valueOf(userid);
        } catch (Exception e) {
            return rv;
        }
        String[] whereargs = new String[]{String.valueOf(id)};

        Cursor csr = mDB.query(TBL_USER,null,whereclause,whereargs,null,null,null);
        if (csr.moveToFirst()) {
            rv.setId(String.valueOf(id));
            rv.setName(csr.getString(csr.getColumnIndex(COL_USER_NAME)));
            rv.setEmail(csr.getString(csr.getColumnIndex(COL_USER_EMAIL)));
            rv.setPassword(csr.getString(csr.getColumnIndex(COL_USER_PASWWORD)));
            rv.setCoins(csr.getInt(csr.getColumnIndex(COL_USER_COINS)));
            rv.setGems(csr.getInt(csr.getColumnIndex(COL_USER_GEMS)));
        }
        csr.close();
        return rv;
    }

    public User getUser(String email, String password) {
        User rv = new User("-1","","","");
        String whereclause = COL_USER_EMAIL + "=? AND " + COL_USER_PASWWORD + "=?";
        String[] whereargs = new String[]{email,password};
        Cursor csr = mDB.query(TBL_USER,null,whereclause,whereargs,null,null,null);
        if (csr.moveToFirst()) {
            rv.setId( String.valueOf(csr.getLong(csr.getColumnIndex(COL_USER_ID))));
            rv.setName(csr.getString(csr.getColumnIndex(COL_USER_NAME)));
            rv.setEmail(csr.getString(csr.getColumnIndex(COL_USER_EMAIL)));
            rv.setPassword(csr.getString(csr.getColumnIndex(COL_USER_PASWWORD)));
            rv.setCoins(csr.getInt(csr.getColumnIndex(COL_USER_COINS)));
            rv.setGems(csr.getInt(csr.getColumnIndex(COL_USER_GEMS)));
        }
        csr.close();
        return rv;
    }

    public User adjustCoinsAndOrGems(User u, int coins, int coin_adjustmode, int gems, int gem_adjustmode) {
        ContentValues cv = new ContentValues();
        User rv;
        User user_fromDB = getUser(u.getId());
        if (user_fromDB.id.equals("-1")) return u; // User not found so return
        switch (coin_adjustmode) {
            case User.ADJUSTTYPE_REPLACE:
                cv.put(COL_USER_COINS,coins);
                break;
            case User.ADJUSTTYPE_ADD:
                if (coins != 0) {
                    cv.put(COL_USER_COINS,user_fromDB.getCoins() + coins);
                }
                break;
            case User.ADJUSTTYPE_MULTIPLY:
                if (coins > 0) {
                    cv.put(COL_USER_COINS,user_fromDB.getCoins() * coins);
                }
                break;
            case User.ADJUSTTYPE_DIVIDE:
                if (coins > 0) {
                    cv.put(COL_USER_COINS,user_fromDB.getCoins() / coins);
                }
                break;
        }
        switch (gem_adjustmode) {
            case User.ADJUSTTYPE_REPLACE:
                cv.put(COL_USER_GEMS,gems);
                break;
            case User.ADJUSTTYPE_ADD:
                if (gems != 0) {
                    cv.put(COL_USER_GEMS,user_fromDB.getGems() + gems);
                }
                break;
            case User.ADJUSTTYPE_MULTIPLY:
                if (gems > 0) {
                    cv.put(COL_USER_GEMS,user_fromDB.getGems() * gems);
                }
                break;
            case User.ADJUSTTYPE_DIVIDE:
                if (gems > 0) {
                    cv.put(COL_USER_GEMS,user_fromDB.getGems() / gems);
                }
                break;
        }
        if (cv.size() < 1) return u;
        String whereclause = COL_USER_ID + "=?";
        String[] whereargs = new String[]{u.getId()};
        mDB.update(TBL_USER,cv,whereclause,whereargs);
        return getUser(user_fromDB.getId());
    }

    public boolean authenticateUser(String email, String password) {
        User u = getUser(email,password);
        return (u.getLongId() > 0);
    }
}