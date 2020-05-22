private void enterClicked() {
final int GET_TEXT_REQUEST_CODE = 1;
Log.i(TAG,"Entered enterClicked()");
// TODO - Save user provided input from the EditText field
String givenText = mEditText.getText().toString();
// TODO - Create a new intent and save the input from the EditText field as an extra
Intent  editText = new Intent();
editText.putExtra("givenText",givenText);
// TODO - Set Activity's result with result code RESULT_OK
setResult(RESULT_OK,editText);
// TODO - Finish the Activity
finish();
     }