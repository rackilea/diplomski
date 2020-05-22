public boolean dispatchKeyEvent(KeyEvent event) {
    if(event.getAction()==KeyEvent.ACTION_DOWN){
        if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            SendMessage msg = new SendMessage(some identifier for enter);
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_DEL) {
            SendMessage msg = new SendMessage(some identifier for delete);
        } else {

            int keyUniCode=event.getUnicodeChar(event.getMetaState());
            if(keyUniCode!=0){
                char charCode=(char) keyUniCode;
                Log.i("Code:",""+keyUniCode);
                SendMessage msg=new SendMessage(charCode);
                msg.execute();
            }
        }
    }
    return super.dispatchKeyEvent(event);
}