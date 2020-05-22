public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener 
 {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

 TextView yourActivityMainTextView=findViewById(R.id.your_txt_view_id) //from activity 
  main xml

    MyClass myClass = new MyClass(yourActivityMainTextView);
    myClass.myMethod();


 }
}