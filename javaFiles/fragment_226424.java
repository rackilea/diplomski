Camera.PictureCallback photoCallback = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            // generate file path for new picture
            String fileName = "myPicture.jpg";
            String mediafile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
               .getCanonicalPath() + "/mydir/" + fileName;

            // launching new activity to modify picture
            Intent myIntent = new Intent(CameraActivity.this,
                ModificationActivity.class);
            Log.e("le chemin de la photo", "" + mediaFile);
            myIntent.putExtra("imagePath", ""+mediaFile);
            startActivity(myIntent);
        }
    };