public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener 
{
    final String numbers = {"1","2","3"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.riga, numbers);
    ListView listView = (ListView)findViewById(R.id.listView);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adattatore, final View componente, int position, long id )
    {
    Toast.makeText(getApplicationContext(), numbers[position], Toast.LENGTH_LONG).show();
    }
}