public class FontHolder {
    private static FontHolder instance;
    public static FontHolder getInstance(Context context){
        if(instance == null) 
            instance = new FontHolder(context);

        return instance;
    }

    private static final String PREF_TABLE = "font_prefs"
    private static final String ACTIVE_FONT_PREF = "active_font_file";
    private static final String DEFAULT_PREF_ASSET = "fonts/default_font.ttf";

    private Context context;
    private Typeface activeTypeFace;

    protected FontHolder(Context context){
        this.context = context.getApplicationContext();

        String activeFilePath = getSavedActiveFont();
        this.activeTypeFace = activeFilePath == null
                ? Typeface.createFromAssets(context.getResources().getAssets()
                : Typeface.createFromFile(new File(activeFilePath));
    }

    private String getSavedActiveFont(){
        return context.getSharedPreferences(PREF_TABLE, 0)
            .getString(ACTIVE_FONT_PREF, null);
    }

    public void setActiveFont(File activeFontFile){
        this.activeFont = Typeface.createFromFile(activeFontFile);

        context.getSharedPreferences(PREF_TABLE, 0)
            .edit()
            .putString(ACTIVE_FONT_PREF, activeFontFile.getAbsolutePath())
            .commit();
    }

    public Typeface getActiveFont(){
        return activeFont;
    }
}