@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    ImageView imgView = (ImageView) findViewById(R.id.the_id);
    imgView.setImageBitmap(((BitmapDrawable) d).getBitmap());
}