public class GalleryPage extends Activity {

private static Uri[] mUrls = null;
private static String[] strUrls = null;
private String[] mNames = null;
private GridView gridview = null;
private Cursor cc = null;
private Button btnMoreInfo = null;
private ProgressDialog myProgressDialog = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.gallery);
    btnMoreInfo = (Button) findViewById(R.id.btnMoreInfo);
    // It have to be matched with the directory in SDCard
    cc = this.getContentResolver().query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null,
            null);

    if (cc != null) {
        myProgressDialog = new ProgressDialog(GalleryPage.this);
        myProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        myProgressDialog.setMessage(getResources().getString(R.string.pls_wait_txt));            
        myProgressDialog.show();

        new Thread() {
            public void run() {
                try {
                    cc.moveToFirst();
                    mUrls = new Uri[cc.getCount()];
                    strUrls = new String[cc.getCount()];
                    mNames = new String[cc.getCount()];
                    for (int i = 0; i < cc.getCount(); i++) {
                        cc.moveToPosition(i);
                        mUrls[i] = Uri.parse(cc.getString(1));
                        strUrls[i] = cc.getString(1);
                        mNames[i] = cc.getString(3);
                        //Log.e("mNames[i]",mNames[i]+":"+cc.getColumnCount()+ " : " +cc.getString(3));
                    }

                } catch (Exception e) {
                }
                myProgressDialog.dismiss();
            }
        }.start();
     gridview = (GridView) findViewById(R.id.gridview);
     gridview.setAdapter(new ImageAdapter(this));

     gridview.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v,
              int position, long id) {
           Intent i = new Intent(GalleryPage.this, BigImage.class);
           Log.e("intent : ", ""+position);
           i.putExtra("imgUrls", strUrls);
           i.putExtra("position", position);
           startActivity(i);
        }
     });
    }

    btnMoreInfo.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent i = new Intent(GalleryPage.this, ChildLogin.class);
            startActivity(i);
        }
    });
}

/**
 * This class loads the image gallery in grid view.
 *
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return cc.getCount();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.galchild, null);

        try {

            ImageView imageView = (ImageView) v.findViewById(R.id.ImageView01);
            //imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            // imageView.setPadding(8, 8, 8, 8);
            Bitmap bmp = decodeURI(mUrls[position].getPath());
            //BitmapFactory.decodeFile(mUrls[position].getPath());
            imageView.setImageBitmap(bmp);
            //bmp.
            TextView txtName = (TextView) v.findViewById(R.id.TextView01);
            txtName.setText(mNames[position]);
        } catch (Exception e) {

        }
        return v;
    }
}

@Override
protected void onStart() {
    // TODO Auto-generated method stub
    super.onStart();
    FlurryAgent.onStartSession(this, "***");
}

/**
 * This method is to scale down the image 
 */
public Bitmap decodeURI(String filePath){

    Options options = new Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(filePath, options);

    // Only scale if we need to 
    // (16384 buffer for img processing)
    Boolean scaleByHeight = Math.abs(options.outHeight - 100) >= Math.abs(options.outWidth - 100);
    if(options.outHeight * options.outWidth * 2 >= 16384){
        // Load, scaling to smallest power of 2 that'll get it <= desired dimensions
        double sampleSize = scaleByHeight
            ? options.outHeight / 100
            : options.outWidth / 100;
        options.inSampleSize = 
            (int)Math.pow(2d, Math.floor(
            Math.log(sampleSize)/Math.log(2d)));
    }

    // Do the actual decoding
    options.inJustDecodeBounds = false;
    options.inTempStorage = new byte[512];  
    Bitmap output = BitmapFactory.decodeFile(filePath, options);

    return output;
}