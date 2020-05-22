private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {

        File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
        if (pictureFile == null){
            Log.d("Logtag:", "Error creating media file, check storage permissions: "
                   );
            return;
        }

        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            fos.write(data);
            fos.close();

            Intent intent = new Intent(this,show_image.class);
            Uri fileUri = Uri.fromFile(pictureFile);
            intent.putExtra(EXTRA_MESSAGE, fileUri.toString());
            startActivity(intent);

        } catch (FileNotFoundException e) {
            Log.d("Logtag:", "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d("Logtag:", "Error accessing file: " + e.getMessage());
        }
    }
};

...