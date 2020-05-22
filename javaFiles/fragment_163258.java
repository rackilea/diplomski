interface ICallback{
    void showMessage();
}

public class MainActivity extends MultiTouchActivity implements ICallback{

TestButton btn;

@Override
public void onCreate(final Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    btn = (TestButton)findViewById(R.id.button4);
    btn.setOnTouchListener(this);
    //register here the callback
    btn.setCallback(this);
}

@Override
public void showMessage()
{
    Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
}

public class TestButton extends Button {

MainActivity m;
ICallback iCallback;
public setCallback(final ICallback iCallback)
{
    this.iCallback = iCallback; 
}
public TestButton(final Context context, final AttributeSet attrs)
{
    super(context, attrs);

    // TODO Auto-generated constructor stub
}

@Override
public boolean onTouchEvent(final MotionEvent event)
{
    if (event.getAction() == MotionEvent.ACTION_UP)
    {
        iCallback.showMessage();
    }
    return super.onTouchEvent(event);
}
}