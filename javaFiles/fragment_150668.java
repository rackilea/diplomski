//MyHelper.java

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(Context context) {
        super(context,"student",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table stud(rollno int primary key,name TEXT,phone long);");
        db.execSQL("insert into stud values(1,'bca',9988998899);");
        db.execSQL("insert into stud values(2,'mca',9988998897);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

//MainActivity.java

public class MainActivity extends AppCompatActivity {

    MyHelper mh;
    SQLiteDatabase db;
    Cursor rs;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHelper mh = new MyHelper(getApplicationContext());
        db = mh.getReadableDatabase();

        lv = (ListView) findViewById(R.id.mylist);

        rs = db.rawQuery("select rollno _id,name,phone from stud",null);

        SimpleCursorAdapter sca = new SimpleCursorAdapter(getApplicationContext(),
                R.layout.detail_adapter,rs,new String[]{"_id","name","phone"},
                new int[]{R.id.textid,R.id.textname,R.id.textphone},0);

        lv.setAdapter(sca);
    }
}


    //activity_main.xml

       <ListView
            android:id="@+id/mylist"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_centerVertical="true"
            android:layout_centerHorizontal="true" />

//detail_adapter.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <TextView
        android:text="TextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textid" />

    <TextView
        android:text="TextView"
        android:layout_marginLeft="25dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textname" />

    <TextView
        android:text="TextView"
        android:layout_marginLeft="25dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/textphone" />
</LinearLayout>