public class YourActivity extends AppCompatActivity {
private Button btn1;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        parent_view = findViewById(android.R.id.content);
        btn1= (Button) findViewById(R.id.button1); //button1 is the id of the button
    bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //do actions
                    }


               });
}