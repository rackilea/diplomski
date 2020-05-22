public class ShowFullList extends AppCompatActivity {

    RecyclerView recyclerViewList;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_full_list);
        recyclerViewList = (RecyclerView)findViewById(R.id.recyclerview);
        databaseReference = FirebaseDatabase.getInstance().getReference("School");
       }
    }