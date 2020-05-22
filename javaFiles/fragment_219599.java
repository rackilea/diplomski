@Override
public View getView(int position, View convertView, ViewGroup parent) {
View v = super.getView(position, convertView, parent);

ImageView profileImage = (ImageView) v.findViewById(R.id.profile_img);
try {
    HashMap<String, String> map = (HashMap<String, String>)getItem(position);
    URL url = new URL(map.get(TAG_IMAGEURL));
    imageProfilo = BitmapFactory.decodeStream(url.openConnection().getInputStream());
    Log.i("Url immagine", urlImage); // here there is only last one

} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
if (imageProfilo != null) {
    profileImage.setImageBitmap(imageProfilo);
} else {
    profileImage.setImageDrawable(v.getResources() .getDrawable(R.drawable.welcome));
}
return v;