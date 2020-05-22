@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
if (resultCode == RESULT_OK && null != data) {
               Uri file = data.getData(); 
              }
else{
// no file selected
}
    }