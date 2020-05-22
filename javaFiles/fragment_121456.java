Use this, I have modified your code..

    public class MainActivity extends AppCompatActivity {

    private ImageButton ourButton;
    private EditText operand1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Views by IDs :
        ourButton = (ImageButton) findViewById(R.id.gobutton);
        operand1 = (EditText) findViewById(R.id.edit_Name);

        ourButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

        String ed_text = operand1.getText().toString().trim();

        if(ed_text.equals(""))
        {

                    Toast.makeText(MainActivity.this, "You did not enter a username", Toast.LENGTH_LONG).show();
         }
         else
        {
           Intent myIntent = new Intent(MainActivity.this, ScreenName.class);
                    MainActivity.this.startActivity(myIntent);
         }
      }
      });

    }