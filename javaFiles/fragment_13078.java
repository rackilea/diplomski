class GraphicsActivity extends Activity {

private static final boolean TEST_PICTURE = true;
int f=0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


}



@Override
public void setContentView(View view) {
    if (TEST_PICTURE) {

        if(f==0){
        ViewGroup vg = new PictureLayout(this);
        vg.addView(view);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vi = inflater.inflate(R.layout.activity_main, vg);
        view = vg;
        }

    }



    super.setContentView(view);
}



/*@Override
public void onConfigurationChanged(Configuration newConfig) {
    // TODO Auto-generated method stub
    super.onConfigurationChanged(newConfig);
    if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
        f=0;
        }else{
         f=1;


        }

}*/