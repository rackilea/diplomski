protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
                imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            BitmapFactory.Options options=new BitmapFactory.Options();
            try
            {
            InputStream is = getContentResolver().openInputStream(selectedImage);
            Bitmap bm = BitmapFactory.decodeStream(is,null,options);
            int Height = bm.getHeight();
            int Width = bm.getWidth();
            int newHeight = 300;
            int newWidth = 300;
            float scaleWidth = ((float) newWidth) / Width;
            float scaleHeight = ((float) newHeight) / Height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0,Width, Height, matrix, true);
            image=toGrayscale(resizedBitmap);
                imageView1 = (ImageView) findViewById(R.id.imgView1);
                imageView1.setImageBitmap(image);
            }
            catch(Exception e)
            {

            }

            pixels = new byte[image.getWidth()*image.getHeight()];
            pixels2 = new int[image.getWidth()*image.getHeight()];
            int k=0;
            for (int i = 0; i < image.getHeight(); i++)
            {
                for (int j = 0; j < image.getWidth(); j++)
                {
                      pixels[k]=(byte)(image.getPixel(j, i));
                      pixels2[k]=unsignedToBytes(pixels[k]);
                      k++;
                }
            }
}