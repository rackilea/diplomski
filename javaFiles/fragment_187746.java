/***************************** onCreate() ***********************************/
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgJoke = (ImageView) findViewById(R.id.img_joke);


        AnimationDrawable animation = new AnimationDrawable();


        Bitmap bmpJoke = BitmapFactory.decodeResource(getResources(), R.drawable.joke);
        splitImage(bmpJoke, 5);

        int duration = 200;    

        for(Bitmap image: chunkedImages){
            BitmapDrawable frame = new BitmapDrawable(image);
            animation.setOneShot(false);
            animation.addFrame(frame, duration);
        }


        imgJoke.setBackgroundDrawable(animation);

        animation.start();
}
/*********** Method to split a single image ****************************/
private void splitImage(Bitmap bitmap, int chunkNumbers) {


        // For height and width of the small image chunks
        int chunkHeight, chunkWidth;

        // To store all the small image chunks in bitmap format in this list
        chunkedImages = new ArrayList<Bitmap>(chunkNumbers);

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap,
        bitmap.getWidth(), bitmap.getHeight(), true);

        chunkHeight = bitmap.getHeight();
        chunkWidth = bitmap.getWidth() / chunkNumbers;

        // xCoord and yCoord are the pixel positions of the image chunks
        int yCoord = 0;

        int xCoord = 0;
        for (int y = 0; y < chunkNumbers; y++) {
            chunkedImages.add(Bitmap.createBitmap(scaledBitmap, xCoord, yCoord,
                    chunkWidth, chunkHeight));
            xCoord += chunkWidth;
        }
        yCoord += chunkHeight;

}