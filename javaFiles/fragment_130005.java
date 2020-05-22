public boolean onKeyDown(int keyCode, KeyEvent event)
{
    if(keyCode == KeyEvent.KEYCODE_BACK) {
        backPressed = true;
        alert.show();
        return true; // shows you consumed the event with your implementation
    }
    // blah, blah, other code
}