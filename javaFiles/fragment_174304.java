public class mainActivity extends Activity implements OnClickListener
{
    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );

        // I do not see any reason to use the Application Context here. Your Activity has the right context for your UI
        // Context context = getApplicationContext();
        setContentView( R.layout.main );

        LinearLayout root = (LinearLayout) findViewById( R.id.myLayout   );   
        View child1 = getLayoutInflater().inflate( R.layout.child, null );

        // Define the button
        final CustomButtom myCustomButton = (CustomButtom)child1.findViewById( R.id.button_id );   

        myCustomButtom.setOnClickListener(this);

        root.addView( myCustomButton );

        // you did this already
        //super.onCreate( savedInstanceState );
    }

    public void onClick(View v)
    {
        Log.d( "test", "Callback executed!" );
    }
}