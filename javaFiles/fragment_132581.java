public class YourApp extends android.app.Application {
    public void onCreate() {
        super.onCreate();

        // typeface caching
        initializeTypefaces();
    }

    public static class Fonts {
        public static Typeface THEOREM;
    }

    private void initializeTypefaces(){
        Fonts.THEOREM   = Typeface.createFromAsset(getAssets(), "fonts/theorem.otf");
    }
}