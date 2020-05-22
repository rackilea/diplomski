public class MainActivity extends AppCompatActivity {

     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        //display images using gridview.
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        final ArrayList<String> message = new ArrayList<>();
        message.add("Message for image 0");
        message.add("Message for image 1");
        message.add("Message for image 2");
        //onClickListeners for each clickable imageViews.
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
   public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
   //create toast for view when clicked.
    String mess = message.get(position);
    Toast.makeText(MainActivity.this, "" + mess, Toast.LENGTH_SHORT).show();
            }
        });
    }
}