// Call to take the picture
startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), PICK_FROM_CAMERA);

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data)
{
    if (requestCode == PICK_FROM_CAMERA)
    {
        Uri uri = data.getData();
            // set the imageview image via uri 
            _previewImage.setImageURI(uri);
    }
}