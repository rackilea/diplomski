@Override
public void onPause() {
  super.onPause();
  if (Build.VERSION..SDK_INT <= 23) {
    //your activity is not visible
    onHidden();
  }
}
@Override
public void onStop() {
  super.onStop();
  if (Build.VERSION..SDK_INT > 23) {
    //your activity is not visible
    onHidden();
  }
}