String lang = Locale.getDefault().getLanguage();
if(lang.equals("de")) {
    Log.i("de", "de");
} else if(lang.equals("fr")) {
    Log.i("fr", "fr");
} else {
    Log.i("en", "en");
}