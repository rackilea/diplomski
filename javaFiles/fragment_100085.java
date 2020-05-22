@Override
public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
    String str = shared_tags.getText().toString();
    if(!str.equals(""))
        shared_tags.setText("");
    // If you want to do something else - do it here
    // Not sure if this will work to identify space - never tried it
    if(!str.contains(" ")) // if this doesn't work try KeyEvent's getAction() method 
        shared_tags.setText("Whatever you want");
}