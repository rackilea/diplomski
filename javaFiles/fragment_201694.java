@Override
public void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    instance_ = this;
    context_ = this.getApplicationContext();
    mainHandler_ = new Handler( Looper.getMainLooper() );
}

public static void runOnMainThread( Runnable runnable ) {
    mainHandler_.post( runnable );
}