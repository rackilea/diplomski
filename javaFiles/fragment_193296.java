selectimage = (Button) findViewById(R.id.selectimg);

    selectimage.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
             Intent i = new  Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                  startActivityForResult(i, PICK_FROM_FILE);                

            }
        }
    });

   protected void onActivityResult(int requestCode, int resultCode, Intent data) {

           if  (resultCode == RESULT_OK) {


        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA  };

        Cursor cursor = getContentResolver().query(selectedImage,
                                   filePathColumn,null,null, null);
        cursor.moveToFirst();

        int  columnIndex = cursor.getColumnIndexfilePathColumn[0]);
        String filePath = cursor.getString(columnIndex);
        cursor.close();

        yourSelectedImage  = BitmapFactory.decodeFile(filePath);
        img.setImageBitmap(yourSelectedImage);