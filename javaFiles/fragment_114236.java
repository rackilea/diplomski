public class MainActivity extends Activity {

    public static final int CONTACT_QUERY_LOADER = 0;
    public static final String QUERY_KEY = "query";
    public EditText cn;
    String query = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cn = (EditText) findViewById(R.id.mainEditText);
                startQuery();
    }

        private void startQuery()
                {
            query = cn.getText().toString();
            // We need to create a bundle containing the query string to    
    send along to the
            // LoaderManager, which will be handling querying the database
    and returning results.
                        if(query!="")
                        {
            Bundle bundle = new Bundle();
            bundle.putString(QUERY_KEY, query);

            ContactablesLoaderCallbacks loaderCallbacks = new    
    ContactablesLoaderCallbacks(this);

            // Start the loader with the new query, and an object that will
    handle all callbacks.
            getLoaderManager().restartLoader(CONTACT_QUERY_LOADER, bundle,
    loaderCallbacks);
        }
                }
    }