public class ActivityA extends Activity {

public static ImageView image;


@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_activityA);

image = (ImageView) findViewById(R.id.image);
image.setImageResource(getIntent().getIntExtra("myImageResource",R.drawable.default_image);
}