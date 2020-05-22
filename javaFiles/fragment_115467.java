@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fingering_chart);

    Intent intent = getIntent();
    String image_name = intent.getStringExtra("image_name");

    // now you have the image_name and you can go on... 

    // 1st get the reference to your ImageView :
    ImageView img = (ImageView) findViewById(R.id.image);
    // 2nd assume you pass as string param the name of the drawable, in this example, regarding previous code, we would like to load image_2.png, so we retrieve the corresponding resource ID like this :
    int resourceID = getResources().getIdentifier(image_name , "drawable", getPackageName());
    // 3rd then we assign it to our ImageView :
    img.setImageResource(resourceID);
    // 4th done!
}