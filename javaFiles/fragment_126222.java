@Override
public void onPause() {
    super.onPause();
    if (call != null){
        call.cancel();
    }
}