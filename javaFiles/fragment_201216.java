public class MainActivity extends AppCompatActivity {

    ListView lv ;
    public static String [] prgmNameList={"Android Dev","SpearHead Inc"}; // You can put dynamic strings in this array .
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList));

    }


}