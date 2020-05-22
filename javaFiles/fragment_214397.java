protected boolean isDemoExpired() {
    Date d = new Date();
    long now = d.getTime();

    long demoStart;
    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);   
    demoStart = settings.getLong(FIRST_USE_DATE, 0);        

    if (demoStart == 0) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(FIRST_USE_DATE, now);
        ****editor.commit();****
        System.out.println(Long.toString(demoStart)); 
        return false;

    }
    return true;
}