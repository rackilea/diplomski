@Override
protected void onDestroy() {
    super.onDestroy();
    if(toast!= null) {
        toast.cancel();
    }
}