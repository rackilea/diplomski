public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Workers> list = new ArrayList<>();
    WorkerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        ApiInterface apiCall = ApiClient.getInterface();
        Call<Result> call = apiCall.getWorkers();

       call.enqueue(new Callback<Result>() {
           @Override
           public void onResponse(Call<Result> call, Response<Result> response) {
               list = response.body().getResult();
               adapter = new WorkerAdapter(MainActivity.this,list);
               recyclerView.setAdapter(adapter);
           }

           @Override
           public void onFailure(Call<Result> call, Throwable t) {

           }
       });

    }}