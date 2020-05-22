public class SecondClass extends Activity {
    protected Context context;

    public SecondClass(Context context){
        this.context = context;
    }

    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.main_view);

        context.initiateMap(mainAppContext,mainObj, mapFrag);

    }

}