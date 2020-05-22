public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}


@Override
public boolean onTouchEvent(MotionEvent event)
{
    switch(event.getAction() & MotionEvent.ACTION_MASK)
{
    case MotionEvent.ACTION_DOWN : //Do something
                                    break;
    case MotionEvent.ACTION_UP : //Do something
                                    break;
    }
    return true;
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}