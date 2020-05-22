public class MainActivity extends AppCompatActivity {
Bitmap bitmap;
Card card;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.jpg);
    LinearLayout linearLayout=findViewById(R.id.ll);
    card=new Card(bitmap,linearLayout,this);
    ....