public class flash extends ActionBarActivity {

    ImageView light; // init your variable
    public Boolean on = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        // find its id with its global variable
        light = (ImageView) findViewById(R.id.light);

        light.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(on){
                    // get the resource drawable
                    light.setImageResource(
                        getResources().getDrawable(R.drawable.flash_off));
                    on = false;
                }else{
                    light.setImageResource(
                        getResources().getDrawable(R.drawable.flash_on));
                    on = true;
                }
            }
        });
    }
    ...
}