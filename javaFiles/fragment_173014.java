public static final int PICK_IMAGE = 1;
private void takePictureFromGalleryOrAnyOtherFolder() 
{
 Intent intent = new Intent();
 intent.setType("image/*");
 intent.setAction(Intent.ACTION_GET_CONTENT);
 startActivityForResult(Intent.createChooser(intent, "Select Picture"),PICK_IMAGE);
}