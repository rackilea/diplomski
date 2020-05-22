@Override
public void onBackPressed() 
{       
    if (screens.size() == 1)
        super.onBackPressed();
    else
    {
        screens.pop();
        setContentView(screens.peek());
        screens.peek().onResume();
    }
}