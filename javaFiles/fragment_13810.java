public class DBAdapter extends SQLiteOpenHelper
{
static String name = "kbcquiz.sqlite";
static String path = "";
static ArrayList<kbc> a;
static SQLiteDatabase sdb;

@Override
public void onCreate(SQLiteDatabase db)
{
    // Your database is already Created, so no need to add anything here
}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
{
    //  Database Not upgraded here
} 

private DBAdapter(Context v) 
{
    super(v, name, null, 1);
    path = "/data/data/" + v.getApplicationContext().getPackageName() + "/databases";
}

public boolean checkDatabase()
{
    SQLiteDatabase db = null;
    try 
    {
        db = SQLiteDatabase.openDatabase(path + "/" + name, null, SQLiteDatabase.OPEN_READONLY);
    } catch (Exception e) 
    {
        e.printStackTrace();
    }
    if (db == null) 
    {
        return false;
    } 
    else
    {
        db.close();
        return true;
    }
}

public static synchronized DBAdapter getDBAdapter(Context v)
{
    return (new DBAdapter(v));
}

public void createDatabase(Context v) 
{
    this.getReadableDatabase();
    try
    {
        InputStream myInput = v.getAssets().open(name);
        // Path to the just created empty db
    String outFileName = path +"/"+ name;
        // Open the empty db as the output stream
    OutputStream myOutput = new FileOutputStream(outFileName);
        // transfer bytes from the inputfile to the outputfile
    byte[] buffer = new byte[1024];
    int length;
    while ((length = myInput.read(buffer)) > 0) 
    {
        myOutput.write(buffer, 0, length);
    }
        // Close the streams
    myOutput.flush();
    myOutput.close();
    myInput.close();
                } catch (IOException e) 
    {
        System.out.println(e);
    }
}

public void openDatabase() 
{
    try 
    {
        sdb = SQLiteDatabase.openDatabase(path + "/" + name, null,
                SQLiteDatabase.OPEN_READWRITE);
    } catch (Exception e) 
     {
        System.out.println(e);
    }
}

    // Method for fetching Data and storing it into ArrayList

    public ArrayList<kbc> getQuestions() 
 {
           //question is the table name, you can also use "SELECT * FROM question" in case 
     Cursor c1 = sdb.rawQuery("SELECT * FROM question ORDER BY RANDOM()", null);
     a = new ArrayList<kbc>();
     while (c1.moveToNext())
    {
        kbc q1 = new kbc(); // kbc is the getter setter class
        //the below code can vary upon ur getter-setter methods & variables
        q1.setSno(c1.getInt(0));
        q1.setQuestion(c1.getString(1));
        q1.setA(c1.getString(2));
        q1.setB(c1.getString(3));
        q1.setC(c1.getString(4));
        q1.setD(c1.getString(5));
        q1.setAnswer(c1.getString(6));

                    a.add(q1);//--Always remember to add the fetched elements of type ArrayList<GetterGetter>
    }
    return a;
}
}