public class MainActivity extends AppCompatActivity{
   @Override
   protected void onCreate(Bundle savedInstanceState){

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       Log.i("MyTag", new MyNDK().getMyString());
   }
}