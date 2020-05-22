public void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);
// if (resultCode == Activity.RESULT_OK) {
if (data != null)
{
    if (requestCode == SELECT_VIDEO) {
        Uri selectedVideo = data.getData();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(selectedVideo, "video/*");
        startActivity(intent);
    } else if (requestCode == SELECT_PHOTO) {

        Uri selectedImage = data.getData();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(selectedImage, "image/*");
        startActivity(intent);
    }
}