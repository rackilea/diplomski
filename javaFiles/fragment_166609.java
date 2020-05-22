protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == REQUEST_CODE) {
        if (resultCode == Activity.RESULT_OK) {
            String[] fileColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(imageUri,
                fileColumn, null, null, null);
            String contentPath = null;
            if (cursor.moveToFirst()) {
                contentPath = cursor.getString(cursor
                    .getColumnIndex(fileColumn[0]));

                Bitmap bmp = BitmapFactory.decodeFile(contentPath);
                ImageView img = (ImageView) findViewById(R.id.imageView1);
                img.setImageBitmap(bmp);


            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Capture Cancelled", Toast.LENGTH_LONG)
                .show();
            } else {
                Toast.makeText(this, "Capture failed", Toast.LENGTH_LONG)
                .show();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);
    }