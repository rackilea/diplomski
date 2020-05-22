public class SearchableActivity extends ListActivity {

    public void onCreate(Bundle savedInstanceState) { 
          super.onCreate(savedInstanceState); 
          Log.d("SEARCH", "HERE");
          handleIntent(getIntent()); 
       } 

       public void onNewIntent(Intent intent) { 
          setIntent(intent); 
          handleIntent(intent); 
       } 

       public void onListItemClick(ListView l, View v, int position, long id) { 
          // call the appropriate detail activity
       } 

       private void handleIntent(Intent intent) { 
          if (Intent.ACTION_SEARCH.equals(intent.getAction())) { 
             String query = intent.getStringExtra(SearchManager.QUERY); 
             doSearch(query); 
          } 
       }    

       private void doSearch(String queryStr) { 
           Toast.makeText(getApplicationContext(), queryStr, Toast.LENGTH_LONG).show();
       } 
}