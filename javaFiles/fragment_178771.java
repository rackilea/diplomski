public class SecondActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    Intent intent = getIntent();
    String filepath = intent.getStringExtra("filepath");

    ImageView imageView = (ImageView) findViewById(R.id.imageView1);

    BitmapFactory.Options opts = new BitmapFactory.Options();
    opts.inSampleSize = 6;
    Bitmap bm = BitmapFactory.decodeFile(filepath, opts);
    imageView.setImageBitmap(bm);
}
}