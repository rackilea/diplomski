public class AnActivity extends Activity implements OnClickListener, Callback
{

    Button          b           = null;
    TextView        t           = null;
    MyThread        mThread     = null;
    public Handler  mainHandler = new Handler( this );


    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.main );

        b = ( Button ) findViewById( R.id.buttonSEND );

        b.setOnClickListener( this );
        mThread = new MyThread( this );
        mThread.start();
    }


    @Override
    public void onClick( View v )
    {
        Message m = Message.obtain();
        m.what = 4;
        mThread.myThreadHandler.sendMessage( m );
    }


    @Override
    public boolean handleMessage( Message msg )
    {
        Toast.makeText( this, "This is AnActivity. What=" + Integer.toString( msg.what ), Toast.LENGTH_SHORT ).show();
        return false;
    }
}