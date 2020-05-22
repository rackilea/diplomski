public void onPinEntered(CharSequence str) {
     if( login( str.toString() ) {
         Toast.makeText(AnimatedEditTextWidgetsActivity.this, "SUCCESS",    Toast.LENGTH_SHORT).show();
     } else {
         Toast.makeText(AnimatedEditTextWidgetsActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
         pinEntry.setText(null);
     }
}