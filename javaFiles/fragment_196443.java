public class FullscreenInfo extends AppCompatActivity {
ImageView selectedImage;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fullscreen_info);
    selectedImage = (ImageView) findViewById(R.id.fullscreen_view_image); // init a ImageView
     String imageUrl = getIntent().getStringExtra("image_url");
      //you can use this image url to load image in your imageview by Using any library like picasso or Glide
}