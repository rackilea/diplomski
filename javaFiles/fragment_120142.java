edit_Text = (EditText) findViewById(R.id.edittext);
edit_Text.setOnFocusChangeListener(new OnFocusChangeListener() {
@Override
public void onFocusChange(View v, boolean hasFocus) {
    if(hasFocus){
           this.setTextSize(LARGE);
    }else {
           this.setTextSize(NORMAL);
    }
   }
});