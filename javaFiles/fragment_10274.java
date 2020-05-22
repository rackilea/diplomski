@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {
        if(event.getAction() == KeyEvent.ACTION_DOWN)
        {
            if( keyCode == KeyEvent.KEYCODE_BACK )
            {
                mTimer.cancel();
            }   
        }
        return super.onKeyDown(keyCode, event);
    }