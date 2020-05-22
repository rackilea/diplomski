private void showImage() {
    String uri = "drawable/icon";

    // int imageResource = R.drawable.icon;
    int imageResource = getResources().getIdentifier(uri, null, getPackageName());

    ImageView imageView = (ImageView) findViewById(R.id.myImageView);
    Drawable image = getResources().getDrawable(imageResource);
    imageView.setImageDrawable(image);
}