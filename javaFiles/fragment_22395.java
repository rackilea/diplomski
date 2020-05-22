public class MainActivity extends AppCompatActivity {

    List<Data> listData1 = new ArrayList<>();
    List<Data> listData2 = new ArrayList<>();
    List<Data> listData3 = new ArrayList<>();
    DataAdapter adapter;
    MapAdapter mapAdapter;
    Context mcontext;
    AlphabetIndexFastScrollRecyclerView alphabetIndexFastScrollRecyclerView;
    HashMap<String, List<Data>> listHash = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext = this;



        listData1.add(new Data("Avik", 20.1));
        listData1.add(new Data("Arnab", 21.1));
        listData1.add(new Data("Anikit", 2));
        listData2.add(new Data("Rajjoy", 3));
        listData2.add(new Data("Sandipan", 4));
        listData2.add(new Data("Arindam", 54));
        listData2.add(new Data("Abhishek", 23));

        listData3.add(new Data("Raju",23));
        listData3.add(new Data("Nagarjuna",21));

        listHash.put("Dry Wash", listData1);
        listHash.put("Iron", listData2);




        alphabetIndexFastScrollRecyclerView = findViewById(R.id.recyclerView);
        alphabetIndexFastScrollRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mapAdapter = new MapAdapter(mcontext, listHash);
        alphabetIndexFastScrollRecyclerView.setAdapter(mapAdapter);

    }
}