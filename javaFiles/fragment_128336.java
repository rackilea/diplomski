public class FullScreenActivity extends Activity {

PhotoViewAttacher mAttacher;
ShareActionProvider mShareActionProvider;
private static final String TAG_ARQUIVO = "arquivo";
String path;
File file;
Intent shareIntent;
ImageView fullImg;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_full_screen);

    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

    fullImg = (ImageView) findViewById(R.id.fullImage);

    Intent i = getIntent();
    path = i.getStringExtra(TAG_ARQUIVO);

    Picasso.with(FullScreenActivity.this).load(path).into(fullImg);
    mAttacher = new PhotoViewAttacher(fullImg);

    Uri bmpUri = getLocalBitmapUri(fullImg);

    shareIntent = new Intent();
    shareIntent.setAction(Intent.ACTION_SEND);
    shareIntent.setType("image/*");
    shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.full_screen, menu);

    MenuItem item = menu.findItem(R.id.menu_item_share);
    mShareActionProvider = (ShareActionProvider) item.getActionProvider();
    if (mShareActionProvider != null) {
        mShareActionProvider.setShareIntent(shareIntent);
    }
    return true;
}

public Uri getLocalBitmapUri(ImageView imageView) {

    Drawable drawable = imageView.getDrawable();
    Bitmap bmp = null;
    if (drawable instanceof BitmapDrawable){
       bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
    } else {
       return null;
    }

    Uri bmpUri = null;
    try {
        File file =  new File(Environment.getExternalStoragePublicDirectory(  
            Environment.DIRECTORY_DOWNLOADS), "share_image_" + System.currentTimeMillis() + ".png");
        file.getParentFile().mkdirs();
        FileOutputStream out = new FileOutputStream(file);
        bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
        out.close();
        bmpUri = Uri.fromFile(file);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return bmpUri;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}