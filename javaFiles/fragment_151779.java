....
    @Override
    public void onSuccess(byte[] bytes) {
         Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
         imageView.setImageBitmap(bitmap);
    }
   ....