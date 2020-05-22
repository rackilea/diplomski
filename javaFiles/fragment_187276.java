private  boolean switched = false;
public void pictureSwitch() {
    ImageView imageView = (ImageView) findViewById(R.id.imgVCat);
    if (switched) {
        imageView.setImageResource(R.drawable.catstart);
    } else {
        imageView.setImageResource(R.drawable.catswitch);
    }
    switched = !switched;
}