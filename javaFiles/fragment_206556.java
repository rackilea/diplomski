public void setLocale(String lang) { 
    myLocale = new Locale(lang); 
    Resources res = getResources(); 
    DisplayMetrics dm = res.getDisplayMetrics(); 
    Configuration conf = res.getConfiguration(); 
    conf.locale = myLocale; 
    res.updateConfiguration(conf, dm); 
    Intent refresh = new Intent(this, AndroidLocalize.class); 
    startActivity(refresh); 
    finish();
}