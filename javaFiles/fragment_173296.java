@Override
protected void onDestroy() {
    super.onDestroy();
    stopService(new Intent(this, YourService.class));

}