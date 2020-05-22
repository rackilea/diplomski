public class MjpegSample extends Activity {
    private MjpegView mv;

    private LinearLayout ll1;
    private LinearLayout nestedL;
    private Button btn1;
    private TextView txt1;

    public void onCreate(Bundle myBundle) {          
        super.onCreate(myBundle);

        //allow legacy-style network queries on UI thread (in case you compile for Android 3.0+, which do not allow
        //network transactions in main UI thread by default)
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 

        final String URL = "http://someURL/mjpg/video.mjpg"; 

        requestWindowFeature(Window.FEATURE_NO_TITLE);          
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Create new button programmatically
        btn1 = new Button(this);
        btn1.setText("Test button 1");
        //set so that content is wrapped in its parent container (which will be the nestedL object below)
        btn1.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Create new TextView programmatically
        txt1 = new TextView(this);
        txt1.setText("Test text 1");
        //set so that content is wrapped in its parent container (which will be the nestedL object below)
        txt1.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //Create new MjpegView programmatically
        mv = new MjpegView(this);
        //set so that content is wrapped in its parent container (which will be the ll1 object below)
        mv.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        nestedL = new LinearLayout(this);
        nestedL.setOrientation(LinearLayout.HORIZONTAL);
        //set so that content is wrapped in its parent container (which will be the ll1 object below)
        nestedL.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        //we add btn1 and txt1 in nestedL LinearLayout (they will be ordered horizontally, according to nestedL orientation
        //as configured above, and all those widgets will not be stretched either)
        nestedL.addView(btn1);
        nestedL.addView(txt1);

        //create the main LinearLayout widget which will be set as the view content using setContentView(...)
        ll1 = new LinearLayout(this);
        ll1.setOrientation(LinearLayout.VERTICAL);
        //we add the other LinearLayout (horizontal one) on top
        ll1.addView(nestedL);
        //then we add the video player thing
        ll1.addView(mv);

        //ll1 is set as the main view for your activity
        setContentView(ll1);  


        mv.setDisplayMode(MjpegView.SIZE_BEST_FIT);
        mv.setSource(MjpegInputStream.read(URL));


    }
}