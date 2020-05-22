// declare all Views here...
ImageView imageView;  //<<<
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

     // initialize Views here after setting layout for Activity..
    imageView= (ImageView)findViewById(R.id.ImageView01);  //<<<<

    Gallery ga = (Gallery)findViewById(R.id.Gallery01);
ga.setAdapter(new ImageAdapter(this));