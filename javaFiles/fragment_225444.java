public class TasksActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {
    private final TAKS_QUERY_LOADER = 0;

    protected void onCreate(Bundle savedInstanceState) {
        // Other code. 

        // Get your cursor loader initialized here. 
        getLoaderManager().initLoader(TASKS_QUERY_LOADER, null, this).forceLoad();
    }
}