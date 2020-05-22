public void onCreate(...) {
    MyImage image = new MyImage(this,R.id.my_image);
    //Or
    MyImage image = new MyImage(this);
    image.createViewById(R.id.myImage);
}