@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);
//check for right result
if (requestCode == 10) {
    if (resultCode == RESULT_OK) {

            //Catching name from 2nd Activity
            Intent GoToMain = data;