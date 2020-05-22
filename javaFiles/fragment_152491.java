@Override
protected void attachBaseContext(Context newBase) {
    SharedPreferences sharedPref = newBase.getSharedPreferences("userLang", Context.MODE_PRIVATE);
    String lang = sharedPref.getString("lang", "");
    super.attachBaseContext(MyContextWrapper.wrap(newBase, lang));
}