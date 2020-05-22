@Override
protected void onStop() {
    super.onStop();

    ImageView myImage = (ImageView) findViewById(R.id.myImage );
    if(myImage .getDrawable() != null)
        myImage.getDrawable().setCallback(null);

    RoundedImageView roundImage = (RoundedImageView) findViewById(R.id.roundImage); // a custom View
    if(roundImage.getDrawable() != null)
        roundImage.getDrawable().setCallback(null);


}