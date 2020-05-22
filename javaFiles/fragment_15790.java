boolean bKeyIsPressed;

@Override public boolean onKeyDown(int keyCode, KeyEvent msg)
{
   switch (keyCode)
   {
     case THE_KEY_I_WANT:
        bKeyIsPressed = true;
        break;
   }
}

@Override public boolean onKeyUp(int keyCode, KeyEvent msg)
{
   switch (keyCode)
   {
     case THE_KEY_I_WANT:
        bKeyIsPressed = false;
        break;
   }
}