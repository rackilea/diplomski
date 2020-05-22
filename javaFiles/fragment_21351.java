public class StartGame extends Activity {

    private ViewManager viewManager = new ViewManager();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView(new ViewPanel(this));    

        viewManager.start(); // start viewManager thread
    }

    // other methods

    public void showExitDialog() {

        viewManager.pause(); // call pause

        // rest of code
    }
}