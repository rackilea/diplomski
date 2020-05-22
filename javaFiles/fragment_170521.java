public class CominSoonActivity extends AppCompatActivity implements RecyclerViewClickItemInterface {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Event> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comin_soon);

        recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Event>();
        adapter = new MyAdapter(CominSoonActivity.this, list, this);
        recyclerView.setAdapter(adapter);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Event e = dataSnapshot1.getValue(Event.class);
                    list.add(e); // This will add it to the adapter 
                    adapter.notifyDataSetChanged();
                }


            }

// the rest of the class