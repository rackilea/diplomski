@Override
protected void onStop() {
    // place your code before super.onStop()
    yourAsyncTaskObj.cancel(true);
    super.onStop();

}