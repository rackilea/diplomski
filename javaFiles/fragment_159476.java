}
@Override
[1] public boolean onKeyDown(int keyCode, KeyEvent event)
{
    if ((keyCode == KeyEvent.KEYCODE_BACK))
    {
[2]         finish();
    }
[3]     return super.onKeyDown(keyCode, event);
}    
}