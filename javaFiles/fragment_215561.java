public class MainActivity extends ActionBarActivity {

        ImageView imgBackground;
        Button loadImgBtn;

        String imgDecodableString;
        BitmapDrawable drawable;

        private static int RESULT_LOAD_IMG = 1;
        private static final String IMAGE_DATA = "image_resource";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            loadImgBtn = (Button)findViewById(R.id.btnSelectImage);
            imgBackground = (ImageView)findViewById(R.id.myImg);


            loadImgBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            /* Create intent to open Image Application like Gallery */
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            /* start the Intent */
                    startActivityForResult(galleryIntent,RESULT_LOAD_IMG);
                }
            });

            if(savedInstanceState != null) {
                Bitmap tmp = savedInstanceState.getParcelable(IMAGE_DATA);
                if(tmp != null) {
                    drawable = new BitmapDrawable(getResources(), tmp);
                    imgBackground.setImageDrawable(drawable);
                }
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            try {
                if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
            /* Get the Image from Data */
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = { MediaStore.Images.Media.DATA };

            /* Get the Cursor */
                    Cursor cursor = getContentResolver().query(selectedImage,filePathColumn,null,null,null);

            /* Move the first row */
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    imgDecodableString = cursor.getString(columnIndex);
                    cursor.close();

            /* Rendering the Image */
                    drawable =  new BitmapDrawable(imgDecodableString);
                    imgBackground.setBackgroundDrawable(drawable);
                }
            } catch (Exception e) {
                message(getBaseContext()," Error : " + e.getMessage(), Toast.LENGTH_SHORT);
            }
        }

        public void message(Context ctx,String msg,int duration) {
            Toast.makeText(ctx,msg,duration).show();
        }

        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            if(drawable != null && drawable.getBitmap() != null) {
                outState.putParcelable(IMAGE_DATA, drawable.getBitmap());
            }
        }

        @Override
        protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
        }
    }

}