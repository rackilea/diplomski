Bitmap bitmap = null;
    try {
        // I'm assuming you have the cursor from somewhere!!
        String imageFile = checkDatabaseValue(cursor);
        if (imageFile == null){
            Toast.makeText(this, "No image was taken for this item. (TOAST IS JUST TESTING PURPOSES)", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!imageFile.isEmpty()){
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Uri.parse(imageFile));
            mFullImage.setImageBitmap(bitmap);
        else{
            Toast.makeText(this, "Empty String. (TOAST IS JUST TESTING PURPOSES)", Toast.LENGTH_SHORT).show();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }