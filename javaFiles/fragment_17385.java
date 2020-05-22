use below two class

package Your 'packagename';


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BistroDB";

    private static final int DATABASE_VERSION =1;

    // Database creation sql statement
    public static final String Table1= "create table table1name ("Your cloumns");";


    public static final String Table2 = "create table table2name ("Your cloumns");";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(table1);
       database.execSQL(table2);

    }

    // Method is called during an upgrade of the database, e.g. if you increase
    // the database version
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
            int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS table1");
        database.execSQL("DROP TABLE IF EXISTS table2");

        onCreate(database);
    }


        public boolean deleteDatabase(Context context) {
            return context.deleteDatabase(DATABASE_NAME);
        }

}