protected void onActivityResult(int requestCode, int resultCode, Intent data) {

Log.i(TAG, "Entered onActivityResult()");
// TODO - Process the result only if this method received both a
// RESULT_OK result code and a recognized request code
// If so, update the Textview showing the user-entered text.
if(requestCode==GET_TEXT_REQUEST_CODE){
    if(resultCode==RESULT_OK){
        mUserTextView.setText(data.getStringExtra("givenText"));

    }//end if

}//end if

  }