public class ImageDisplayActivity extends FragmentActivity{

    public static final String KEY_PATH = "path";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_display);
        final ImageView imageDisplay = (ImageView)findViewById(R.id.image_displayer);
        final Bundle extras = getIntent().getExtras();
        if(extras != null){
            final String path = extras.getString(KEY_PATH);
            File imgFile = new File(path);
            Bitmap bitmap = decodeFile(imgFile);
            imageDisplay.setImageBitmap(bitmap);
        }

    }


    private Bitmap decodeFile(File f){
        Bitmap b = null;
        try {
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;

            FileInputStream fis = new FileInputStream(f);
            BitmapFactory.decodeStream(fis, null, o);
            fis.close();

            int scale = 1;
            if (o.outHeight > 50 || o.outWidth > 50) {
                scale = (int)Math.pow(2, (int) Math.round(Math.log(50 / (double) Math.max(o.outHeight, o.outWidth)) / Math.log(0.5)));
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            fis = new FileInputStream(f);
            b = BitmapFactory.decodeStream(fis, null, o2);
            fis.close();
        } catch (IOException e) {
        }
        return b;
    }

}