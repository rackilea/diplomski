Bitmap bitmap = cache.get(number);
if (bitmap == null) {
    Log.d(TAG, "I will download image for " + name + ".");
    // i set a dummy image to avoid to show the wrong picture
    holder.contactPhoto.setImageResource(R.drawable.ic_action_person);
    loadUserProfilePhoto(number, holder.contactPhoto);
}
else {
    // show it directly
    Log.d(TAG, "I already have " + name + " in cache.");
    holder.contactPhoto.setImageBitmap(bitmap);
}