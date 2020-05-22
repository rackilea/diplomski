public void incrementKarmaPoints(Context context) {
    SharedPreferences settings;
    Editor editor;
    settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    editor = settings.edit();
    this.karmaPoints+=1; // or ++this.karmaPoints
    editor.putInt("karma",this.karmaPoints );
    editor.apply();
}