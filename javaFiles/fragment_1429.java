public boolean keyDown(int keycode, int time)
{
   if (keycode == Keypad.SEND)
  {
    //handle your event
    return true;
  }
  return super.keyDown(keycode, time);
}