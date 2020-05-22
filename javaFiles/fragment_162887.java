public static Intent getOpenFacebookIntent(Context context) {

   try {
    context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
    return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/<id_here>"));
   } catch (Exception e) {
    return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/<user_name_here>"));
   }
}