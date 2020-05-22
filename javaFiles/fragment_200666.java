int i = 0;
@Override
public boolean onKeyDown(int keyCode, KeyEvent event)
{
 if(keyCode == KeyEvent.KEYCODE_POWER)
 {
    i++;
    if(i == 2)
    {
        // Do something you want
    }
 }
return super.onKeyDown(keyCode, event);
}