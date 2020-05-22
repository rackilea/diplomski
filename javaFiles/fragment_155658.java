public class DatabaseHandler implements DatabaseConnector
{
    private SQLiteDatabase database;
     ....
    Context context;

   public DatabaseHandler(Context context){

       this.context=context;
   }

    @Override
    public void createConnection() 
    {

        try
        {
            database = context.openOrCreateDatabase("esoftDatabase", 
                           MODE_PRIVATE, null);
            // your code here....
        }
        catch(SQLException sql)
        {
            Toast.makeText(context, sql.getMessage(), 
                    Toast.LENGTH_LONG).show();
        }

    }