public void initialze()
{
    imageView = (ImageView)findViewById(R.id.image);
    button = (Button) findViewById(R.id.camera);
}
    public void takePhoto()
    {

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,CAPTURE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){

            switch (requestCode)
            {
                case CAPTURE_PHOTO:
                    Toast.makeText(this, "Saved to Gallery", Toast.LENGTH_SHORT).show();
                    bitmap = (Bitmap)data.getExtras().get("data");
                    imageView.setImageBitmap(bitmap);
                    saveImagetoGallery(bitmap); // Added this 
                    break;
                default:
                    break;
            }


        }

    }