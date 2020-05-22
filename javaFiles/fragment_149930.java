public class SecoundActivity extends AppCompactActivity{
    private ImageView image;
     @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Intent intent=getIntent();
       int position = intent.getExtras().getInt("image");
        setContentView(R.layout.secound_view);
        image=(ImageView) findViewById(R.id.image);
      image.setImageResource(position);
}
}