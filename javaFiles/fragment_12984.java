Bundle b = getIntent.getExtra();

if(b.getString("check_this").equals("mainactivity")){
textView.setText(myValue). // this screen is opened from splash
}else{
 textView.setText(myNewValue). // this is from editactivity
}