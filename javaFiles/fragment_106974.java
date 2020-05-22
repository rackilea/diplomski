public class Persistence { 

    private static final String PREFERENCES = "tourist_guide_preferences";
    private SharedPreferences settings;
    private SharedPreferences.Editor editor;
    private Context context;


    public Persistence(Context context)
    {
        this.context = context;
        settings = context.getSharedPreferences(PREFERENCES, 0);
        editor = settings.edit();
    }

    public int getRadius()
    {
        return settings.getInt("radius", 2000);
    }

    public int getClusterSize()
    {
        return settings.getInt("cluster", 50);
    }

    public void setRadius(int radius)
    {
        editor.putInt("radius", radius);
        editor.commit();
    }

    public void setClusterSize(int size)
    {
        editor.putInt("cluster", size);
        editor.commit();        
    }   
}