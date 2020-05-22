mCameraSource.takePicture(null, new CameraSource.PictureCallback(){
   @Override
    public  void onPictureTaken (byte[] data){
       // Do something with the data (this is the JPEG image)
   }
});