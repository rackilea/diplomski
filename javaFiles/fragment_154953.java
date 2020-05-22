public class MainActivity extends Activity
{ 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final GridView gridview = (GridView) findViewById(R.id.gridView1);

        Table t = new Table(-1d, null);

        gridview.setAdapter(new ImageAdapter(this, t));

        gridview.setOnItemClickListener(new OnItemClickListener() 
        {
             public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
             {
                 Toast.makeText(v.getContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();
             }
        });
   }
}