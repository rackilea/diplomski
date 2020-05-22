protected void foo() {
    Date d = new Date();
    long now = d.getTime();

    long start;
    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    start = settings.getLong(FIRST_USE_DATE, 0);
    Log.w(this.getClass().getName(), Long.toString(start));     

    if (start == 0) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putLong(FIRST_USE_DATE, now);
        ***editor.commit();***       
    }
}