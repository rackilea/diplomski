@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    Bitmap bitmap;
    if (requestCode == 1) {
        if (resultCode == showImages.RESULT_OK) {
            String result = data.getStringExtra("result");
            Toast.makeText(this.context, "Clicked item is " + result, Toast.LENGTH_SHORT).show();
            bitmap = BitmapFactory.decodeFile(result);
            RecyclerViewHolder.img_profile.setImageBitmap(bitmap);
        }
        if (resultCode == showImages.RESULT_CANCELED) {
            //Write your code if there's no result
        }
    }
}