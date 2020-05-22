public class MainActivity extends AppCompatActivity {

public static  final String EXTRA_MESSAGE2="message";
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Intent intent = new Intent(this , FoodActivity.class).putExtra(EXTRA_MESSAGE2,1);
    startActivity(intent);
}