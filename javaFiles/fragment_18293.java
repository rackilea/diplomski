protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageView DrawingImage = (ImageView) this.findViewById(R.id.imageView2);

    Bitmap bitmap2 = Bitmap.createBitmap((int) getWindowManager()
        .getDefaultDisplay().getWidth(), (int) getWindowManager()
        .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);

    Canvas canvas = new Canvas(bitmap2);
    DrawingImage.setImageBitmap(bitmap2);

    // Draw Rectangle

    Paint paint = new Paint();
    paint.setColor(Color.GREEN);
    paint.setStyle(Paint.Style.FILL);

    float left = 20;
    float top = 20;
    float right = 50;
    float bottom = 100;

    canvas.drawRect(left, top, right, bottom, paint);

    ImageView image = (ImageView) findViewById(R.id.imageView1);
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
    image.setImageBitmap(bitmap);

    int posX=(int)image.getX();
    int posY=(int)image.getY();
    double height=image.getHeight();
    double width=image.getWidth();
}