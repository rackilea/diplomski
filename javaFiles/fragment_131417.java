ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
           ......
           imageLoader=new  ImageLoader(ClassName.this);


            ImageView imageView = (ImageView) findViewById(R.id.DISP_IMG);
           ......
            imageLoader.DisplayImage(YourImageURLHere,imageView);