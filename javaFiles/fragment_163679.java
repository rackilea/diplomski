// For a simple view:
@Override public void onCreate(Bundle savedInstanceState) {
  ...
  ImageView yourImageView = (ImageView) findViewById(R.id.image_view_id);

  Glide.with(this).load("image_url").into(yourImageView);
}