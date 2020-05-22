@Override
protected void onCreate(...) {
    doOnNewIntent( getIntent() );
}

@Override
protected void onNewIntent(Intent intent) {
    doOnNewIntent( intent );
}

private void doOnNewIntent(Intent intent) {
    String id = intent.getStringExtra("ID_NUMBER");
}