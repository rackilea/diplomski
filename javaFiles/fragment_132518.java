public class MainActivity extends AppCompatActivity implements LocaleListener{
   android.content.res.Resources res;

   RecyclerView recyclerView;

   Context context;
   String[] numbers;

   RecyclerView.Adapter recyclerView_Adapter;

   RecyclerView.LayoutManager recyclerViewLayoutManager;


   @Override
   protected void onCreate(Bundle savedInstanceState) {

      super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);
      res = getResources();

      numbers = res.getStringArray(R.array.abc);

      getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
      getSupportActionBar().setCustomView(R.layout.action_bar);

      context = getApplicationContext();

      recyclerView = (RecyclerView) findViewById(R.id.recycler_view1);

    //Change 2 to your choice because here 2 is the number of Grid layout Columns in each row.
       recyclerViewLayoutManager = new GridLayoutManager(context, 2);

       recyclerView.setLayoutManager(recyclerViewLayoutManager);

       recyclerView_Adapter = new RecyclerViewAdapter(context,numbers);

       recyclerView_Adapter.setLocaleListener(this); // some change here

       recyclerView.setAdapter(recyclerView_Adapter);

   }

   @Override
   public void setLocale(String lang) {
       Locale myLocale = new Locale(lang);
       Resources res = context.getResources();
       DisplayMetrics dm = res.getDisplayMetrics();
       Configuration conf = res.getConfiguration();
       conf.locale = myLocale;
       res.updateConfiguration(conf, dm);
       Intent refresh = new Intent(this, MainActivity.class);
       startActivity(refresh);
       finish();
    }
}