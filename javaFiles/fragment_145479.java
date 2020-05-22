if(responseCode == activity.RESULT_OK && requestCode==Constants.PICK_GALLERY){
        Uri selectedImage = data.getData();
        String[] filePath = {MediaStore.Images.Media.DATA};
        try {
            Cursor c = activity.getContentResolver().query(selectedImage, filePath, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String picturePath = c.getString(columnIndex);
            c.close();
            if(picturePath==null) {
                picturePath=selectedImage.getPath();
            }
            //Use picturePath for setting bitmap  or to crop 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }