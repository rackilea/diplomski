public class MyImageActivity extends Activity {
        private final String TAG = "MyImageActivity";
        private ImageView mIV;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            Log.e(TAG, "onCreate");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mylayout);
            mIV = (ImageView) findViewById(R.id.image_display);
        }

        @Override
        protected void onResume() {
            Log.e(TAG, "onResume");
            super.onResume();
        }

        public void pressedStart(View view) {
        new SlideShowTask().execute();
        }

    private class SlideShowTask extends AsyncTask<Void, Drawable, Void>{

      private Bitmap mFaceBitmap;
          private AssetManager mAssetMan = null;
          private String[] mImgFileNames = null;
          private int mBitmapWidth;
          private int mBitmapHeight;

      @Override
      Protected Void doInBackground(Void... params){
        mAssetMan = getAssets();
        Log.e(TAG, "pressedStart");
                try {
                    mImgFileNames = mAssetMan.list("my_subfolder");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                Log.d(TAG, "mImgFileNames = " + mImgFileNames);
                Log.d(TAG, "number of image files = " + mImgFileNames.length);

            for (int i = 0; i < mImgFileNames.length; i++) {
                Log.d(TAG, "image file name = " + mImgFileNames[i]);

                InputStream istr = null;
                try {
                    istr = mAssetMan.open("my_subfolder/" + mImgFileNames[i]);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // load the photo
                Bitmap b = BitmapFactory.decodeStream(istr);
                mFaceBitmap = b.copy(Bitmap.Config.RGB_565, true); 
                b.recycle();

                mBitmapWidth = mFaceBitmap.getWidth();
                mBitmapHeight = mFaceBitmap.getHeight();  
                Log.d(TAG, "mBitmapWidth = " + mBitmapWidth);
                Log.d(TAG, "mBitmapHeight = " + mBitmapHeight);

                Drawable drawable = new BitmapDrawable(getResources(), mFaceBitmap);
        publishProgress(drawable);
                SystemClock.sleep(5000);
            }
      }

      @Override
      Protected Void onProgressUpdate(Drawable... values){
        super.onProgressUpdate(values);
        mIV.setImageDrawable(values[0]);
        mIV.invalidate();
      }
    }
}