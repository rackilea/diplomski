public class MainActivity extends AppCompatActivity {

  //the problem is here
  private MainActivity this_Variable=this;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);


  }

  public void quitGame(View v){
    this_Variable.finishAffinity();
  }

}