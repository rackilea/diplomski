public class FullImageActivity extends AppCompatActivity {

    TouchImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("ViewPager");

        setContentView(R.layout.activity_full_image);

        Intent i = getIntent();
        TouchImageView img = new TouchImageView(this);

        int position = i.getExtras().getInt("id");
        ImageAdapter adapter = new ImageAdapter(FullImageActivity.this);


        img = (TouchImageView) findViewById(R.id.img);
        img.setMaxZoom(4f);   
        Picasso.with(getApplicationContext()).load(adapter.mImages[position]).into(img);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
}