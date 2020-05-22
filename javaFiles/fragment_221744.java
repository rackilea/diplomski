if (requestCode == CAMERA_REQUEST) {
      Bitmap datifoto = null;
      Uri picUri = data.getData();//<- get Uri here from data intent
       if(picUri !=null){
         try {
             datifoto = android.provider.MediaStore.Images.Media.getBitmap(
                                     this.getContentResolver(), 
                                     picUri);
         } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
         } catch (IOException e) {
            throw new RuntimeException(e);
         }
    }