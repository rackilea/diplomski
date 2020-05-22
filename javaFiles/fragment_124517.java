public class Home extends AppCompatActivity {

Button loginButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    loginButton = (Button) findViewById(R.id.button_login);

    loginButton.setOnClickListener(new OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Home.this, Login.class);
            startActivity(intent);
        } 

    });
}