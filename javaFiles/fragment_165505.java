public class ExtremeBeatAnnihilation extends Cocos2dxActivity{

    private static final int REQUEST_SONG_FILE = 0;   // flag for file explore to return a selected song
    private static Object activity;                   // current running instance of this activity
    private String selectedSong;                      // song that was selected in the file explorer

    // called on the startup of the game; will save the instance created to be returned later
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activity = this;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    // returns the currently running instance of this activity
    public static Object getObject()
    {
        Log.i("cppCall", "Returning activity");
        return activity;
    }

    // starts the file explore activity to allow the user to choose a song on their SD card
    public void startupFileExplore()
    {
        try
        {
            Intent fileExploreIntent = new Intent(ExtremeBeatAnnihilation.this, FileExplore.class);

            if(fileExploreIntent != null)
            {
                startActivityForResult(fileExploreIntent, REQUEST_SONG_FILE);
            }
            else 
            {
                Log.d("Extreme Beat Annihilation", "FileExploreIntent null\n");
            }
        }
        catch(Exception e)
        {
            Log.d("Extreme", "Error" + e.getMessage());
        }
    }

    // returns the selected song
    public String getSelectedSong()
    {
        return selectedSong;
    }

    // called when returning from the file explore; gets the selected song that was returned
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_SONG_FILE)
        {
            selectedSong = data.getStringExtra("Song File");
        }
    }

    static {
        System.loadLibrary("game");
    }
}