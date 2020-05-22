public class MainActivity extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
            setSupportActionBar(toolbar);    

           Recyclerview list = (RecyclerView) findViewById(R.id.list);
           //set adapter
        }

        //other methods where I make use of ListActivity
    }