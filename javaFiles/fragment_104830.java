public class MainActivity extends AppCompatActivity implements FragmentRefresh{
ImageView ivSettings;
private RecyclerView rvInsta;

//DB
private DBController dbcon;
private ImageRecyclerAdaptor imageRecyclerAdaptor;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_history);

    dbcon = new DBController(this);

    rvInsta= (RecyclerView) findViewById(R.id.rvInstaImages);
    imageRecyclerAdaptor = new ImageRecyclerAdaptor(this);
    rvInsta.setLayoutManager(new LinearLayoutManager(this));
    rvInsta.setAdapter(imageRecyclerAdaptor);


    rvInsta.setHasFixedSize(true);
    rvInsta.setItemViewCacheSize(20);
    rvInsta.setDrawingCacheEnabled(true);
    rvInsta.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
    imageRecyclerAdaptor.notifyDataSetChanged();

}

@Override public void refresh() {
    if (imageRecyclerAdaptor!= null) {
        imageRecyclerAdaptor.onRefreshh();
    }
}