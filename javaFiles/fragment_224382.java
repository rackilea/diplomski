@Override
protected void onPause() {
    super.onPause();
    if(Logout != null) {
        Logout.callOnClick();
    }
}