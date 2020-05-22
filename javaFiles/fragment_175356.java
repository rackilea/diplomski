SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
String picturePath = prefs.getString("profilePic", "");
if(!picturePath.equals("")){
      ImageView imageView = (ImageView) findViewById(R.id.imageView1);
      imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
}